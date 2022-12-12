package com.dmvirtualstore.services;

import java.util.Date;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.dmvirtualstore.domain.Cliente;
import com.dmvirtualstore.domain.ItemPedido;
import com.dmvirtualstore.domain.Pagamento;
import com.dmvirtualstore.domain.PagamentoComBoleto;
import com.dmvirtualstore.domain.PagamentoComCartao;
import com.dmvirtualstore.domain.PagamentoComPix;
import com.dmvirtualstore.domain.Pedido;
import com.dmvirtualstore.domain.enuns.EstadoPagamento;
import com.dmvirtualstore.repositories.ItemPedidoRepository;
import com.dmvirtualstore.repositories.PagamentoRepository;
import com.dmvirtualstore.repositories.PedidoRepository;
import com.dmvirtualstore.security.UserSS;
import com.dmvirtualstore.services.exception.AuthorizationException;
import com.dmvirtualstore.services.exception.ObjectNotFoundException;

import feign.FeignException.FeignClientException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private CarrinhoService carrinhoService;
	
	@Autowired
	private BoletoService boletoService;
	
	@Autowired
	private CartaoService cartaoService;
	
	@Autowired
	private PixService pixService;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	@Autowired
	private ProdutoService produtoService;
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private FreteService freteService;

	

	public Pedido find(Integer id) { 
		 Optional<Pedido> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Pedido.class.getName())); 
		} 
	
	
	public Pedido insert(Pedido obj) {
			
		obj.setId(null);
		obj.setInstante(new Date());
		obj.setVencimento(new Date());
		obj.setCliente(clienteService.find(obj.getCliente().getId()));
		obj.getPagamento().setEstado(EstadoPagamento.PENDENTE);
		obj.getPagamento().setPedido(obj);
		obj.setLogradouro(obj.getCliente().getLogradouro());
		obj.setNumero(obj.getCliente().getNumero());
		obj.setComplemento(obj.getCliente().getComplemento());
		obj.setBairro(obj.getCliente().getBairro());
		obj.setCep(obj.getCliente().getCep());
		obj.setLocalidade(obj.getCliente().getLocalidade());
		obj.setUf(obj.getCliente().getUf());
		
		
		//CALCULAR FRETE
		obj.setFrete(freteService.calcularFrete(obj.getCliente().getCep()));
		
		
		obj = repo.save(obj);
		
		for (ItemPedido ip : obj.getItens()) {
			ip.setDesconto(0.0);
			ip.setProduto(produtoService.find(ip.getProduto().getId()));
			ip.setPreco(ip.getProduto().getPrice());
			ip.setPedido(obj);
		}
		
		if (obj.getPagamento() instanceof PagamentoComBoleto) {
			PagamentoComBoleto pagto = (PagamentoComBoleto) obj.getPagamento();
			boletoService.preencherPagamentoComBoleto(pagto, obj.getInstante());
		}
		
		if (obj.getPagamento() instanceof PagamentoComPix) {
			System.out.println("<< 1>> ");
			PagamentoComPix pagto = (PagamentoComPix) obj.getPagamento();
			System.out.println("<< 2>> ");
			pixService.preencherPagamentoComPix(pagto, obj);
			System.out.println("<< 7>> ");
		}
		
		if (obj.getPagamento() instanceof PagamentoComCartao) {
			System.out.println("<< 1-c>> ");
			PagamentoComCartao pagto = (PagamentoComCartao) obj.getPagamento();
			System.out.println("<< 2-c>> ");
			System.out.println(obj.getPagamento().toString());
			cartaoService.pagamentoComCartao(pagto, obj);
			System.out.println("<< 7-c>> ");
		}
		
		pagamentoRepository.save(obj.getPagamento());
		itemPedidoRepository.saveAll(obj.getItens());
		emailService.sendOrderConfirmationHtmlEmail(obj);
		
		carrinhoService.cleanCarrinho();
		return obj;
	}
	
	public Page<Pedido> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {
		UserSS user = UserService.authenticated();
		if (user == null) {
			throw new AuthorizationException("Acesso negado");
		}
		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);
		Cliente cliente =  clienteService.find(user.getId());
		return repo.findByCliente(cliente, pageRequest);
	}
	
	public boolean estornarPagamento(Integer id, Cliente cliente) {
		Optional<Pedido> obj = repo.findById(id);
		System.out.println(obj.get().getCliente().getId());
		System.out.println(cliente.getId());
		
		if(obj.get().getCliente().getId() == cliente.getId()) {
			
			try {
				if (obj.get().getPagamento() instanceof PagamentoComPix) {
					System.out.println("<< 1>> ");
					PagamentoComPix pagto = (PagamentoComPix) obj.get().getPagamento();
					System.out.println("<< 2>> ");
					pixService.estornoPagamentoPix(pagto.getIdPagamentoPix());
					System.out.println("<< 7>> ");
					System.out.println(obj.get().getPagamento().getEstado());
					obj.get().getPagamento().setEstado(EstadoPagamento.CANCELADO);
					System.out.println(obj.get().getPagamento().getEstado());
					pagamentoRepository.save(obj.get().getPagamento());
				}
				
				if (obj.get().getPagamento() instanceof PagamentoComCartao) {
					System.out.println("<< 1>> ");
					PagamentoComCartao pagto = (PagamentoComCartao) obj.get().getPagamento();
					System.out.println("<< 2>> ");
					cartaoService.estornarPagamentoCartao(pagto);
					System.out.println("<< 7>> ");
					System.out.println(obj.get().getPagamento().getEstado());
					obj.get().getPagamento().setEstado(EstadoPagamento.CANCELADO);
					System.out.println(obj.get().getPagamento().getEstado());
					pagamentoRepository.save(obj.get().getPagamento());

				}
				return true;
			
			
			} catch (FeignClientException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			}
			
		}else {
			return false;
		}

		
		
		
		
		
		 
	}
	

}

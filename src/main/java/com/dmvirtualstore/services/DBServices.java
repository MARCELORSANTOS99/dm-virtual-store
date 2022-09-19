package com.dmvirtualstore.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.dmvirtualstore.domain.Categoria;
import com.dmvirtualstore.domain.Cidade;
import com.dmvirtualstore.domain.Cliente;
import com.dmvirtualstore.domain.Endereco;
import com.dmvirtualstore.domain.Estado;
import com.dmvirtualstore.domain.ItemPedido;
import com.dmvirtualstore.domain.Pagamento;
import com.dmvirtualstore.domain.PagamentoComBoleto;
import com.dmvirtualstore.domain.PagamentoComCartao;
import com.dmvirtualstore.domain.Pedido;
import com.dmvirtualstore.domain.Produto;
import com.dmvirtualstore.domain.enuns.EstadoPagamento;
import com.dmvirtualstore.domain.enuns.Perfil;
import com.dmvirtualstore.domain.enuns.TipoCliente;
import com.dmvirtualstore.repositories.CategoriaRepository;
import com.dmvirtualstore.repositories.CidadeRepository;
import com.dmvirtualstore.repositories.ClienteRepository;
import com.dmvirtualstore.repositories.EnderecoRepository;
import com.dmvirtualstore.repositories.EstadoRepository;
import com.dmvirtualstore.repositories.ItemPedidoRepository;
import com.dmvirtualstore.repositories.PagamentoRepository;
import com.dmvirtualstore.repositories.PedidoRepository;
import com.dmvirtualstore.repositories.ProdutoRepository;


@Service
public class DBServices {
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;
	
	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;
	
	@Autowired
	private ItemPedidoRepository itemPedidoRepository ;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	public void instatiateTestDataBase() throws ParseException {
		
		Categoria cat1 = new Categoria(null, "Ouro");
		Categoria cat2 = new Categoria(null, "Prata");
		
		Categoria cat3 = new Categoria(null, "Cama mesa e banho");
		Categoria cat4 = new Categoria(null, "Perfumaria");
		Categoria cat5 = new Categoria(null, "Jardinagem");
		Categoria cat6 = new Categoria(null, "Decoração");
		Categoria cat7 = new Categoria(null, "Eletrônicos");
		
		Produto p1 = new Produto(null, "ANEL CRISTAL", 129.90, "ANEL CRISTAL VERDE EM PRATA 925 ESTERLINA - REGULÁVEL", "un", "https://images.yampi.me/assets/stores/oculosnow/uploads/images/anel-cristal-verde-em-prata-925-esterlina-regulavel-61983f365217a-medium.png");
		Produto p2 = new Produto(null, "Colar com Pingente", 0.01, "O colar com pingente coração 3D em ouro 18k é para todos os apaixonados, além de cair bem com todos os looks, pois é uma peça com pingente clássico!", "un", "https://virtualjoias.com/media/catalog/product/cache/2606ad8a2e237282be5631f3e1487bf0/c/o/colar-com-pingente-de-coracao-ouro-18k.jpg?quality=100");
		


		cat1.getProdutos().addAll(Arrays.asList(p1,p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		


		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3,cat4,cat5,cat6,cat7));
		produtoRepository.saveAll(Arrays.asList(p1,p2));
		
		Estado est1 = new Estado(null, "Minas Gerais");
		Estado est2 = new Estado(null, "São Paulo");

		Cidade c1 = new Cidade(null, "Uberlândia", est1);
		Cidade c2 = new Cidade(null, "São Paulo", est2);
		Cidade c3 = new Cidade(null, "Campinas", est2);

		est1.getCidades().addAll(Arrays.asList(c1));
		est2.getCidades().addAll(Arrays.asList(c2,c3));

		estadoRepository.saveAll(Arrays.asList(est1,est2));
		cidadeRepository.saveAll(Arrays.asList(c1,c2,c3));
		
		Cliente cli1 = new Cliente(null, "Debora Mendes", "marcelo.r.santos99@hotmail.com", "92598650000", TipoCliente.PESSOAFISICA,pe.encode("123"));
		cli1.getTelefones().addAll(Arrays.asList("11-98564841","11-56663985"));
		
		Cliente cli2 = new Cliente(null, "Marcelo Santos", "marcelo.badjoca@gmail.com", "89501493032", TipoCliente.PESSOAFISICA,pe.encode("123"));
		cli2.addPerfil(Perfil.ADMIN);
		cli2.getTelefones().addAll(Arrays.asList("11-98564841","11-56663985"));


		Endereco e1 = new Endereco(null, "Rua Zike Tuma", "118", "bl2", "Jd Ubirajara", "04458-000", cli1, c2);
		Endereco e2 = new Endereco(null, "Rua Sobe e desce", "39", "bl1", "Jd Umbuiá", "04777-000", cli1, c3);
		Endereco e3 = new Endereco(null, "R Floriano", "39", "bl1", "Jd Umbuiá", "04777-000", cli2, c3);


		cli1.getEnderecos().addAll(Arrays.asList(e1,e2));
		cli2.getEnderecos().addAll(Arrays.asList(e3));

		clienteRepository.saveAll(Arrays.asList(cli1,cli2));
		enderecoRepository.saveAll(Arrays.asList(e1,e2,e3));
		
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 


		Pedido ped1 = new Pedido(null, sdf.parse("12/02/2022 06:34"),cli1,e1);
		Pedido ped2 = new Pedido(null, sdf.parse("08/02/2022 15:34"),cli1,e2);

		Pagamento pagto1 = new PagamentoComCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		ped1.setPagamento(pagto1);

		Pagamento pagto2 = new PagamentoComBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("13/02/2022 00:00"), null);
		ped2.setPagamento(pagto2);

		cli1.getPedidos().addAll(Arrays.asList(ped1,ped2));

		pedidoRepository.saveAll(Arrays.asList(ped1,ped2));
		pagamentoRepository.saveAll(Arrays.asList(pagto1,pagto2));
		
		ItemPedido ip1 = new ItemPedido(ped1,p1,0.00,1,p1.getPrice());
		ItemPedido ip3 = new ItemPedido(ped2,p2,100.00,1,p2.getPrice());

		ped1.getItens().addAll(Arrays.asList(ip1));
		ped2.getItens().addAll(Arrays.asList(ip3));


		p1.getItens().addAll(Arrays.asList(ip1));
		p2.getItens().addAll(Arrays.asList(ip3));
	

		itemPedidoRepository.saveAll(Arrays.asList(ip1,ip3));
		
	}
	
}

package com.dmvirtualstore.services;

import java.util.Arrays;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmvirtualstore.domain.Carrinho;
import com.dmvirtualstore.domain.Carrinhoitem;
import com.dmvirtualstore.domain.Cliente;
import com.dmvirtualstore.domain.Produto;
import com.dmvirtualstore.dto.CarrinhoNewDTO;
import com.dmvirtualstore.repositories.CarrinhoItemRepository;
import com.dmvirtualstore.repositories.CarrinhoRepository;

@Service
public class CarrinhoService {
	
	@Autowired
	private CarrinhoRepository repo;
	
	@Autowired
	private ProdutoService produtoService;	
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private CarrinhoItemRepository carrinhoItemRepository ;
	
	

	public Carrinho findByCliente(Integer id) {
		
		System.out.println("<<<3>>");
		Cliente cliente =  clienteService.find(id);
		return repo.findByCliente(cliente);
	}
	
	
	public void inserirProdutoNoCarrinho(CarrinhoNewDTO objDto) {
	
	
		System.out.println("<<<1>>>");
		Carrinho carrinho = findByCliente(Integer.parseInt(objDto.getUserId()));		
	
		System.out.println("<<<2>>>");
		Produto produto = produtoService.find(objDto.getIdProduct());
		System.out.println("PRODUTO => "+ produto.getId());
		
		Carrinhoitem cartItem = new Carrinhoitem(carrinho,produto,objDto.getQuantity());
	
		carrinho.getItems().addAll(Arrays.asList(cartItem));
		
		produto.getItensCarrinho().addAll(Arrays.asList(cartItem));
		
		
		carrinhoItemRepository.save(cartItem);
		
	}

public void updateProdutoNoCarrinho(CarrinhoNewDTO objDto) {
	
	System.out.println("PRODUTO UPDATE => ");
	Carrinho carrinho = findByCliente(Integer.parseInt(objDto.getUserId()));
	Produto produto = produtoService.find(objDto.getIdProduct());

	System.out.println("TAMANHO 0 -> " + carrinho.getItems().size());
	
	
	
	for (Carrinhoitem carrinhoitem : carrinho.getItems()) {
		
		if(objDto.getIdProduct() == carrinhoitem.getProduto().getId()) {
					
			carrinhoitem.setQuantity(objDto.getQuantity());
						
			carrinhoItemRepository.save(carrinhoitem);
			
			if(objDto.getQuantity() == 0) {
								
				carrinhoItemRepository.deleteWithZero();
			
		}
		
	}

	}

	}


	public void cleanCarrinho() {
	
	carrinhoItemRepository.cleanCarrinho();
	
	}
}

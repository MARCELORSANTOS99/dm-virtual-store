package com.dmvirtualstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmvirtualstore.domain.Carrinho;
import com.dmvirtualstore.domain.Cliente;
import com.dmvirtualstore.repositories.CarrinhoRepository;

@Service
public class CarrinhoService {
	
	@Autowired
	private CarrinhoRepository repo;
	
	@Autowired
	private ClienteService clienteService;
	
	

	public Carrinho findByCliente(Integer id) {
		
		System.out.println("<<<3>>>");
		Cliente cliente =  clienteService.find(id);
		return repo.findByCliente(cliente);
	}

}

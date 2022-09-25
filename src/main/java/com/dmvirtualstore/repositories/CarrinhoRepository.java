package com.dmvirtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dmvirtualstore.domain.Carrinho;
import com.dmvirtualstore.domain.Cliente;


@Repository
public interface CarrinhoRepository extends JpaRepository <Carrinho, Integer>{
	
	@Transactional(readOnly = true)
	Carrinho findByCliente(Cliente cliente);

	
}
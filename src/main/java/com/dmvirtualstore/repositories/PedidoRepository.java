package com.dmvirtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmvirtualstore.domain.Pedido;


@Repository
public interface PedidoRepository extends JpaRepository <Pedido, Integer>{

	
}
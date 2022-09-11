package com.dmvirtualstore.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmvirtualstore.domain.Cliente;
import com.dmvirtualstore.domain.ItemPedido;

@Repository
public interface ItemPedidoRepository extends JpaRepository <ItemPedido, Integer>{

}

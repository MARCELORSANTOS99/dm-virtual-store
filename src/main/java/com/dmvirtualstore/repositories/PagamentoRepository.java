package com.dmvirtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dmvirtualstore.domain.Pagamento;


@Repository
public interface PagamentoRepository extends JpaRepository <Pagamento, Integer>{

	
}
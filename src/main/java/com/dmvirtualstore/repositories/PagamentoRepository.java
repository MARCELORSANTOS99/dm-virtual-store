package com.dmvirtualstore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dmvirtualstore.domain.Estado;
import com.dmvirtualstore.domain.Pagamento;


@Repository
public interface PagamentoRepository extends JpaRepository <Pagamento, Integer>{

	
}
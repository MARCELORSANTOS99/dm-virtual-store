package com.dmvirtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dmvirtualstore.domain.PagamentoComPix;


@Repository
public interface PagamentoPixRepository extends JpaRepository <PagamentoComPix, Integer>{

	@Transactional(readOnly = true)
	PagamentoComPix findByIdPagamentoPix(Integer idPagamentoPix);
}
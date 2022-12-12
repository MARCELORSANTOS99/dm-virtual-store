package com.dmvirtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dmvirtualstore.domain.Frete;


@Repository
public interface FreteRepository extends JpaRepository <Frete, Integer>{

	@Transactional(readOnly = true)
	@Query("SELECT obj FROM Frete obj WHERE :cep >= obj.inicialCep AND :cep <= obj.finalCep")
	Frete findFrete(@Param("cep") Integer cep);
}

package com.dmvirtualstore.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.transaction.annotation.Transactional;


import com.dmvirtualstore.domain.Categoria;
import com.dmvirtualstore.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Integer>{
	
	@Transactional(readOnly=true)
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.title LIKE %:title% AND cat IN :categorias")
	Page<Produto> findDistinctByTitleContainingAndCategoriasIn( @Param("title")String nome,@Param("categorias") List<Categoria> categorias, Pageable pageRequest);

}

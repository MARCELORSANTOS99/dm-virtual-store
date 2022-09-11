package com.dmvirtualstore.repositories;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.dmvirtualstore.domain.Categoria;
import com.dmvirtualstore.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository <Produto, Integer>{

}

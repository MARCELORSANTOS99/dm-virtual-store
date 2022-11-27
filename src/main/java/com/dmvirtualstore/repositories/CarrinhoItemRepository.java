package com.dmvirtualstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.dmvirtualstore.domain.Carrinhoitem;


@Repository
public interface CarrinhoItemRepository extends JpaRepository <Carrinhoitem, Integer>{
	
	
	@Transactional(readOnly = true)
	@Modifying
	@Query("delete from Carrinhoitem b where b.quantity=0")
	Integer deleteWithZero();
	
	@Transactional(readOnly = true)
	@Modifying
	@Query("delete from Carrinhoitem b where b.quantity>0")
	Integer cleanCarrinho();
	
	
	
	
}
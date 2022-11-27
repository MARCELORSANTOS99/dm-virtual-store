package com.dmvirtualstore.dto;

import java.io.Serializable;



public class CarrinhoNewDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String userId;
	private Integer idProduct; ;
	private Integer quantity; ;
	

	public CarrinhoNewDTO(String userId, Integer idProduct, Integer quantity) {
		super();
		this.userId = userId;
		this.idProduct = idProduct;
		this.quantity = quantity;
	}


	public CarrinhoNewDTO() {}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public Integer getIdProduct() {
		return idProduct;
	}


	public void setIdProduct(Integer idProduct) {
		this.idProduct = idProduct;
	}


	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	


	
	
	

}

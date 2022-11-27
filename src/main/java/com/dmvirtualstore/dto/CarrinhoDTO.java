package com.dmvirtualstore.dto;

import java.io.Serializable;

import com.dmvirtualstore.domain.Estado;

public class CarrinhoDTO implements Serializable {
	
	
	private static final long serialVersionUID = 1L;
	
	private String userId;
	

	public CarrinhoDTO(String userId) {
		super();
		this.userId = userId;
	}


	public CarrinhoDTO() {}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	
	
	

}

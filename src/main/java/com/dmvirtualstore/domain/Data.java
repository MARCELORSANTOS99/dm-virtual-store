package com.dmvirtualstore.domain;

import java.io.Serializable;

//Classe para o receber o id do pagamento via pix na notificação de pagamento
public class Data implements Serializable{
	private static final long serialVersionUID = 1L;
	private String id;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	
}

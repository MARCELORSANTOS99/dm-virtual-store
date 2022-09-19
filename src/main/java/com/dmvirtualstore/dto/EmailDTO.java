package com.dmvirtualstore.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EmailDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	@Email(message = "O Tamanho deve ser entre 5 e 120 caracateres")
	private String email;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public EmailDTO() {
		super();
	}
	
	

}

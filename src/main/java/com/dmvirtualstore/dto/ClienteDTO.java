package com.dmvirtualstore.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.dmvirtualstore.domain.Cliente;


public class ClienteDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private Integer id;

	@NotEmpty(message = "Prenchimento obrigatório")
	@Length(min = 5, max=120, message = "O Tamanho deve ser entre 5 e 120 caracateres")
	private String nome;


	@NotEmpty(message = "Prenchimento obrigatório")
	@Email(message = "O Tamanho deve ser entre 5 e 120 caracateres")
	private String email;



	public ClienteDTO() {
	}


	public ClienteDTO(Cliente obj) {

		id = obj.getId();
		nome = obj.getNome();
		email = obj.getEmail();

	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}







}

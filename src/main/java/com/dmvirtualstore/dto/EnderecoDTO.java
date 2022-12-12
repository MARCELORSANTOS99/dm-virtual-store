package com.dmvirtualstore.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

public class EnderecoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	private String logradouro;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	private String numero;
	
	private String complemento;
	
	
	@NotEmpty(message = "Prenchimento obrigatório")
	private String bairro;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	private String cep;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	private String localidade;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	private String uf;

	

	public EnderecoDTO() {
		super();
	}
	
	



	public EnderecoDTO(
			@NotEmpty(message = "Prenchimento obrigatório") String logradouro,
			@NotEmpty(message = "Prenchimento obrigatório") String numero,
			String complemento,
			@NotEmpty(message = "Prenchimento obrigatório") String bairro,
			@NotEmpty(message = "Prenchimento obrigatório") String cep,
			@NotEmpty(message = "Prenchimento obrigatório") String localidade,
			@NotEmpty(message = "Prenchimento obrigatório") String uf) {
		super();
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cep = cep;
		this.localidade = localidade;
		this.uf = uf;
	}

	public String getLogradouro() {
		return logradouro;
	}



	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}



	public String getNumero() {
		return numero;
	}



	public void setNumero(String numero) {
		this.numero = numero;
	}



	public String getComplemento() {
		return complemento;
	}



	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}



	public String getBairro() {
		return bairro;
	}



	public void setBairro(String bairro) {
		this.bairro = bairro;
	}



	public String getCep() {
		return cep;
	}



	public void setCep(String cep) {
		this.cep = cep;
	}



	public String getLocalidade() {
		return localidade;
	}



	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}





	public String getUf() {
		return uf;
	}





	public void setUf(String uf) {
		this.uf = uf;
	}
	
	
	
	
	
	
	

}

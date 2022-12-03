package com.dmvirtualstore.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.dmvirtualstore.domain.Cliente;
import com.dmvirtualstore.services.validation.ClienteInsert;

@ClienteInsert
public class ClienteNewDTO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String id;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	@Length(min = 5, max=120, message = "O Tamanho deve ser entre 5 e 120 caracateres")
	private String nome;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	@Email(message = "O Tamanho deve ser entre 5 e 120 caracateres")
	private String email;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	private String cpfOuCnpj;
	private Integer tipo;
	
	@NotEmpty
	private String senha;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	private String logradouro;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	private String numero;
	
	private String complemento;
	
	private String token;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	private String bairro;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	private String cep;

	@NotEmpty(message = "Prenchimento obrigatório")
	private String telefone1;
	private String telefone2;
	private String telefone3;

	@NotEmpty(message = "Prenchimento obrigatório")
	private String localidade;
	
	@NotEmpty(message = "Prenchimento obrigatório")
	private String uf;

	public ClienteNewDTO() {
	}
	
	

	public ClienteNewDTO(Cliente c, String tkn) {
		super();
		this.id = c.getId().toString();
		this.nome = c.getNome();
		this.email = c.getEmail();
		this.cpfOuCnpj = c.getCpfOuCnpj();
		this.logradouro = c.getLogradouro();
		this.numero = c.getNumero();
		this.complemento = c.getComplemento();
		this.token = tkn;
		this.bairro = c.getBairro();
		this.cep = c.getCep();
		this.telefone1 = c.getTelefones().iterator().next();
		this.telefone2 = c.getTelefones().iterator().next();
		this.telefone3 = c.getTelefones().iterator().next();
		this.localidade = c.getLocalidade();
		this.uf = c.getUf();
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

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public void setCpfOuCnpj(String cpfOuCnpj) {
		this.cpfOuCnpj = cpfOuCnpj;
	}

	public Integer getTipo() {
		return tipo;
	}

	public void setTipo(Integer tipo) {
		this.tipo = tipo;
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

	public String getTelefone1() {
		return telefone1;
	}

	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}

	public String getTelefone2() {
		return telefone2;
	}

	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}

	public String getTelefone3() {
		return telefone3;
	}

	public void setTelefone3(String telefone3) {
		this.telefone3 = telefone3;
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



	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	





}

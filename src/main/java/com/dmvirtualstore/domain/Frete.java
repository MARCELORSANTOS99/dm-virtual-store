package com.dmvirtualstore.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Frete implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String regiao;
	private String uf;
	private Integer inicialCep;
	private Integer finalCep;
	private Double valor;
	
	
	
	public Frete() {
		
	}
	
	
	public Frete(String regiao, String uf, Integer inicialCep, Integer finalCep, Double valor) {
		super();
		this.regiao = regiao;
		this.uf = uf;
		this.inicialCep = inicialCep;
		this.finalCep = finalCep;
		this.valor = valor;
	}





	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public String getRegiao() {
		return regiao;
	}



	public void setRegiao(String regiao) {
		this.regiao = regiao;
	}



	public String getUf() {
		return uf;
	}



	public void setUf(String uf) {
		this.uf = uf;
	}



	public Integer getInicialCep() {
		return inicialCep;
	}



	public void setInicialCep(Integer inicialCep) {
		this.inicialCep = inicialCep;
	}



	public Integer getFinalCep() {
		return finalCep;
	}



	public void setFinalCep(Integer finalCep) {
		this.finalCep = finalCep;
	}



	public Double getValor() {
		return valor;
	}



	public void setValor(Double valor) {
		this.valor = valor;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Frete [id=");
		builder.append(id);
		builder.append(", regiao=");
		builder.append(regiao);
		builder.append(", uf=");
		builder.append(uf);
		builder.append(", inicialCep=");
		builder.append(inicialCep);
		builder.append(", finalCep=");
		builder.append(finalCep);
		builder.append(", valor=");
		builder.append(valor);
		builder.append("]");
		return builder.toString();
	}
	
		

}

package com.dmvirtualstore.domain;

import javax.persistence.Entity;

import com.dmvirtualstore.domain.enuns.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("pagamentoComCartao")
public class PagamentoComCartao extends Pagamento{


	private static final long serialVersionUID = 1L;

	private Integer numeroDeParcelas;
	private String numeroDoCartao;
	private String validadeCartao;
	private String titularCartao;
	private String cvvCartao;
	private String bandeira;
	private String returnMessage;
	private String returnCode;
	private String paymentId;
	

	public PagamentoComCartao() {}

	public PagamentoComCartao(Integer id, EstadoPagamento estado, Pedido pedido, Integer numeroDeParcelas) {
		super(id, estado, pedido);

		this.numeroDeParcelas = numeroDeParcelas;

	}
	
	

	public String getReturnMessage() {
		return returnMessage;
	}

	public void setReturnMessage(String returnMessage) {
		this.returnMessage = returnMessage;
	}

	public String getReturnCode() {
		return returnCode;
	}

	public void setReturnCode(String returnCode) {
		this.returnCode = returnCode;
	}

	public String getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(String paymentId) {
		this.paymentId = paymentId;
	}

	public Integer getNumeroDeParcelas() {
		return numeroDeParcelas;
	}

	public void setNumeroDeParcelas(Integer numeroDeParcelas) {
		this.numeroDeParcelas = numeroDeParcelas;
	}

	public String getNumeroDoCartao() {
		return numeroDoCartao;
	}

	public void setNumeroDoCartao(String numeroDoCartao) {
		this.numeroDoCartao = numeroDoCartao;
	}

	public String getValidadeCartao() {
		return validadeCartao;
	}

	public void setValidadeCartao(String validadeCartao) {
		this.validadeCartao = validadeCartao;
	}

	public String getTitularCartao() {
		return titularCartao;
	}

	public void setTitularCartao(String titularCartao) {
		this.titularCartao = titularCartao;
	}

	public String getCvvCartao() {
		return cvvCartao;
	}

	public void setCvvCartao(String cvvCartao) {
		this.cvvCartao = cvvCartao;
	}
	
	

	public String getBandeira() {
		return bandeira;
	}

	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PagamentoComCartao [numeroDeParcelas=");
		builder.append(numeroDeParcelas);
		builder.append(", numeroDoCartao=");
		builder.append(numeroDoCartao);
		builder.append(", validadeCartao=");
		builder.append(validadeCartao);
		builder.append(", titularCartao=");
		builder.append(titularCartao);
		builder.append(", cvvCartao=");
		builder.append(cvvCartao);
		builder.append("]");
		return builder.toString();
	}
	
	



}

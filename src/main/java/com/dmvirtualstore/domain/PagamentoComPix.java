package com.dmvirtualstore.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import com.dmvirtualstore.domain.enuns.EstadoPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;

@Entity
@JsonTypeName("pagamentoComPix")
public class PagamentoComPix  extends Pagamento{

	private static final long serialVersionUID = 1L;


	private Integer idPagamentoPix ;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm")
	private Date dataVencimento;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataPagamento;
	
	private String copiaEcola ;
	
	@Column(length=40000)
	private String qrCodeImage;

	public PagamentoComPix() {

	}

	public PagamentoComPix(Integer id, EstadoPagamento estado, Pedido pedido, Date dataVencimento, Date dataPagamento) {
		super(id, estado, pedido);
		this.dataPagamento = dataPagamento;
		this.dataVencimento = dataVencimento;
	}
	

	public Integer getIdPagamentoPix() {
		return idPagamentoPix;
	}

	public void setIdPagamentoPix(Integer idPagamentoPix) {
		this.idPagamentoPix = idPagamentoPix;
	}

	public Date getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(Date dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public Date getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(Date dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

	public String getCopiaEcola() {
		return copiaEcola;
	}

	public void setCopiaEcola(String copiaEcola) {
		this.copiaEcola = copiaEcola;
	}

	public String getQrCodeImage() {
		return qrCodeImage;
	}

	public void setQrCodeImage(String qrCodeImage) {
		this.qrCodeImage = qrCodeImage;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("PagamentoComPix [idPagamentoPix=");
		builder.append(idPagamentoPix);
		builder.append(", dataVencimento=");
		builder.append(dataVencimento);
		builder.append(", dataPagamento=");
		builder.append(dataPagamento);
		builder.append(", copiaEcola=");
		builder.append(copiaEcola);
		builder.append(", qrCodeImage=");
		builder.append(qrCodeImage);
		builder.append("]");
		return builder.toString();
	}
	
	



}

package com.dmvirtualstore.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.dmvirtualstore.domain.ItemPedido;
import com.dmvirtualstore.domain.PagamentoComCartao;
import com.dmvirtualstore.domain.PagamentoComPix;
import com.dmvirtualstore.domain.Pedido;
import com.dmvirtualstore.domain.enuns.FormaPagamento;
import com.fasterxml.jackson.annotation.JsonFormat;



public class PedidoDTO implements Serializable {


	private static final long serialVersionUID = 1L;

	private Integer id;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date instante;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm")
	private Date vencimento;
	
	private Set<ItemPedido> items = new HashSet<>();
	private String copiaecola;
	private String qrCodeImage;
	private Double total;
	private Double frete;
	private String pagamento;
	private String formaPagamento;
	private String numeroCartao;
	private String bandeira;
	private EnderecoDTO endereco;
		

	public PedidoDTO(Pedido obj) {
		super();
		this.id = obj.getId();
		this.instante = obj.getInstante();
		this.vencimento = obj.getVencimento();
		this.items =  obj.getItens();
	
		if (obj.getPagamento() instanceof PagamentoComCartao) {
			PagamentoComCartao pagto = (PagamentoComCartao) obj.getPagamento();
			this.formaPagamento = FormaPagamento.CARTAO.getDescricao();
			this.numeroCartao = pagto.getNumeroDoCartao();
			this.bandeira = pagto.getBandeira();
			
		}
		
		if (obj.getPagamento() instanceof PagamentoComPix) {
			PagamentoComPix pagtoPix = (PagamentoComPix) obj.getPagamento();
			this.copiaecola = pagtoPix.getCopiaEcola();	
			this.qrCodeImage = pagtoPix.getQrCodeImage();
			this.formaPagamento = FormaPagamento.PIX.getDescricao();
		}
		
		
		
		
		
		this.endereco = new EnderecoDTO(
				obj.getLogradouro(),
				obj.getNumero(),
				obj.getComplemento(),
				obj.getBairro(),
				obj.getCep(),
				obj.getLocalidade(),
				obj.getUf()
				);
		
		
		this.total = obj.getValorTotal();
		this.frete = obj.getFrete();
		this.pagamento = obj.getPagamento().getEstado().getDescricao();
		
	}



	public PedidoDTO() {}
	



	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}



	public Date getInstante() {
		return instante;
	}



	public void setInstante(Date instante) {
		this.instante = instante;
	}



	public Date getVencimento() {
		return vencimento;
	}



	public void setVencimento(Date vencimento) {
		this.vencimento = vencimento;
	}



	public Set<ItemPedido> getItems() {
		return items;
	}



	public void setItems(Set<ItemPedido> items) {
		this.items = items;
	}



	public String getCopiaecola() {
		return copiaecola;
	}



	public void setCopiaecola(String copiaecola) {
		this.copiaecola = copiaecola;
	}



	public String getQrCodeImage() {
		return qrCodeImage;
	}



	public void setQrCodeImage(String qrCodeImage) {
		this.qrCodeImage = qrCodeImage;
	}



	public Double getTotal() {
		return total;
	}
	
	



	public void setTotal(Double total) {
		this.total = total;
	}



	public String getPagamento() {
		return pagamento;
	}



	public void setPagamento(String pagamento) {
		this.pagamento = pagamento;
	}



	public String getFormaPagamento() {
		return formaPagamento;
	}



	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}



	public String getNumeroCartao() {
		return numeroCartao;
	}



	public void setNumeroCartao(String numeroCartao) {
		this.numeroCartao = numeroCartao;
	}



	public String getBandeira() {
		return bandeira;
	}



	public void setBandeira(String bandeira) {
		this.bandeira = bandeira;
	}



	public EnderecoDTO getEndereco() {
		return endereco;
	}
	
	



	public Double getFrete() {
		return frete;
	}



	public void setFrete(Double frete) {
		this.frete = frete;
	}



	public void setEndereco(EnderecoDTO endereco) {
		this.endereco = endereco;
	}



	
	



	





	





}

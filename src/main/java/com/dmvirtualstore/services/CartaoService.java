package com.dmvirtualstore.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dmvirtualstore.domain.CieloRequest;
import com.dmvirtualstore.domain.CieloResponseEstorno;
import com.dmvirtualstore.domain.CieloResponsePayment;
import com.dmvirtualstore.domain.CreditCard;
import com.dmvirtualstore.domain.PagamentoComCartao;
import com.dmvirtualstore.domain.PaymentRequest;
import com.dmvirtualstore.domain.Pedido;
import com.dmvirtualstore.domain.enuns.EstadoPagamento;
import com.dmvirtualstore.feign.client.FeignClientDataCielo;


 
@Service
public class CartaoService {
	
	

	@Autowired
	FeignClientDataCielo cieloClient;
	
	@Value("${spring.cielo.merchant.id}")
	private String merchantId;
	
	@Value("${spring.cielo.merchant.key}")
	private String merchantKey;

	public void pagamentoComCartao(PagamentoComCartao pagto, Pedido obj) {
		
		System.out.println(pagto.getNumeroDoCartao());
		Calendar cal = Calendar.getInstance();
		cal.setTime(obj.getInstante());
		cal.add(Calendar.DAY_OF_MONTH, 7);
		
		System.out.println("<< 3-c>> ");
		CreditCard creditCard = new CreditCard(pagto.getNumeroDoCartao(),pagto.getTitularCartao(),pagto.getValidadeCartao(), pagto.getCvvCartao(),pagto.getBandeira());
		PaymentRequest paymentRequest = new PaymentRequest("CreditCard",converterDoubleToInteger(obj.getValorTotal()), 1, "123456789ABCD", creditCard);
		
		CieloRequest cieloRequest = new CieloRequest("2014111703",paymentRequest);
		
		System.out.println("<< 3-A-c>> " + paymentRequest.getAmount());
		
		try {
						
			CieloResponsePayment response = cieloClient.checkOutCartao(merchantId, merchantKey, cieloRequest);
			
			System.out.println("<< 4-c>> ");
			
			
			System.out.println(response.getMerchantOrderId());
			pagto.setReturnCode(response.getPayment().getReturnCode());
			System.out.println(response.getPayment().getReturnCode());
			
			if(response.getPayment().getReturnCode().equals("4") ||response.getPayment().getReturnCode().equals("6") ) {
				System.out.println("<< 4-c1>> ");
				pagto.setEstado(EstadoPagamento.PREPARACAO);
				
			}else {
				System.out.println("<< 4-c2>> ");
				pagto.setEstado(EstadoPagamento.CANCELADO);
			}
			
			pagto.setPaymentId(response.getPayment().getPaymentId());
			pagto.setReturnMessage(response.getPayment().getReturnMessage());
			
			//char lastCardNumber = paymentResponse.getCreditCard().getCardNumber().charAt(paymentResponse.getCreditCard().getCardNumber().length()-4);
			pagto.setBandeira(response.getPayment().getCreditCard().getBrand());
			pagto.setNumeroDoCartao(response.getPayment().getCreditCard().getCardNumber());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	
	}
	
	public void estornarPagamentoCartao(PagamentoComCartao pagto) {
		
		
		CieloResponseEstorno response = cieloClient.estornarPagamentoCartao("a15b7095-9b04-4407-839d-0b742488dbf7", "HBYYGLYBBRRPBHHFXIHLKRCMGPKBBNJKRGYBRATX", pagto.getPaymentId());
		System.out.println(response.toString());
		if(response.getReasonMessage() == "Successful") {
			pagto.setEstado(EstadoPagamento.CANCELADO);
		}

	}
	
	public Integer converterDoubleToInteger(double valor) {
		
		Integer valorConvertido;
		
		System.out.println("<<<<<<Conversão>>>>>");
		
		System.out.println(valor);//3309.9
		
		
		String str = String.format("%1$,.2f", valor);

		System.out.println(str);//3,309.90
		
		String replaceString=str.replace(".","");//replaces all occurrences of "is" to "was"
		String nova =replaceString.replace(",","");//replaces all occurrences of "is" to "was"
		
		System.out.println(nova);//3309.90

		valorConvertido = Integer.parseInt(nova);

		
		return valorConvertido;
	}
}

package com.dmvirtualstore.services;

import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.dmvirtualstore.domain.Identification;
import com.dmvirtualstore.domain.MercadoPagoData;
import com.dmvirtualstore.domain.MercadoPagoRequest;
import com.dmvirtualstore.domain.PagamentoComPix;
import com.dmvirtualstore.domain.PayerRequest;
import com.dmvirtualstore.domain.Pedido;
import com.dmvirtualstore.domain.StatusPaymentPix;
import com.dmvirtualstore.feign.client.FeignClientData;


 
@Service
public class PixService {
	

	@Autowired
	FeignClientData mercadoPagoClient;
	
	@Value("${spring.mercadopago.token}")
	private String token;
	

	public void preencherPagamentoComPix(PagamentoComPix pagto, Pedido obj) {
		System.out.println("<< 4>> ");
		Calendar cal = Calendar.getInstance();
		cal.setTime(obj.getInstante());
		cal.add(Calendar.HOUR_OF_DAY, 1);
		pagto.setDataVencimento(cal.getTime());
		System.out.println("<< 5>> ");
		
		Identification identification = new Identification(obj.getCliente().getCpfOuCnpj(),"CPF");
		
		PayerRequest payer = new PayerRequest(obj.getCliente().getNome(),obj.getCliente().getNome(),obj.getCliente().getEmail(),identification);


		MercadoPagoRequest request = new MercadoPagoRequest("Pagamento Pedido "+ obj.getId(),payer,converterDoubleToApi(obj.getValorTotal()),"https://www.google.com/","pix");
		System.out.println(obj.getValorTotal());
		System.out.println(request.getTransaction_amount());
		System.out.printf("%.2f", obj.getValorTotal() );
		System.out.println("");
	
		
		MercadoPagoData m = mercadoPagoClient.checkOutPix(token,request);
		System.out.println(m.getId());
		System.out.println(m.getPayment_method_id());
		System.out.println("<< 6>> ");
		
		pagto.setIdPagamentoPix(m.getId());
		pagto.setCopiaEcola(m.getPoint_of_interaction().getTransaction_data().getQr_code());
		pagto.setQrCodeImage(m.getPoint_of_interaction().getTransaction_data().getQr_code());
		
		
		
	}
	
	
	public void estornoPagamentoPix(Integer idPagamentoPix) {
		
		StatusPaymentPix status = new StatusPaymentPix();
		
		
		MercadoPagoData m = mercadoPagoClient.estornarPix("Bearer TEST-5372134168916464-111117-be645e8977177fe3644d88612ef5f8d1-63517358",idPagamentoPix,status);
		
	}
	
public double converterDoubleToApi(double valor) {
		
	
	//Formatar casas decimais
	System.out.println("FORMATAÇÃO PIX");

	String str = String.format("%.2f", valor);
	//System.out.println(String.format("%1$,.2f", valor));
	
	//String to double
	double str1 = Double.parseDouble(str);
	System.out.println(str1);

	
	return str1;
		
	
	}
	
	
	
	
}

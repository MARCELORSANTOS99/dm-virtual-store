package com.dmvirtualstore.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.dmvirtualstore.domain.MercadoPagoData;
import com.dmvirtualstore.domain.MercadoPagoRequest;
import com.dmvirtualstore.domain.StatusPaymentPix;

@FeignClient(name="tokenMercadoPago",url="https://api.mercadopago.com/v1/")
public interface FeignClientData {
	
	@PostMapping("/payments")
	MercadoPagoData checkOutPix(@RequestHeader("Authorization") String token, @RequestBody MercadoPagoRequest mercadoPagoData);

	@PutMapping("/payments/{idPagamentoPix}")
	MercadoPagoData estornarPix(@RequestHeader("Authorization")String token, @PathVariable Integer idPagamentoPix, @RequestBody StatusPaymentPix status);
	
	@GetMapping("/payments/{idPagamentoPix}")
	MercadoPagoData statusPagamentoPix(@RequestHeader("Authorization")String token, @PathVariable Integer idPagamentoPix);


}

package com.dmvirtualstore.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import com.dmvirtualstore.config.FeignConfig;
import com.dmvirtualstore.domain.CieloRequest;
import com.dmvirtualstore.domain.CieloResponseEstorno;
import com.dmvirtualstore.domain.CieloResponsePayment;
import com.dmvirtualstore.domain.Pedido;

@FeignClient(name="cielo",url="https://apisandbox.cieloecommerce.cielo.com.br/1/sales",configuration = FeignConfig.class)
public interface FeignClientDataCielo {
			
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	CieloResponsePayment checkOutCartao(@RequestHeader("MerchantId") String merchantId,@RequestHeader("MerchantKey") String merchantKey,  @RequestBody CieloRequest cieloRequest);

	@PutMapping(value = "/{paymentId}/void",produces = MediaType.APPLICATION_JSON_VALUE)
	CieloResponseEstorno estornarPagamentoCartao(
			@RequestHeader("MerchantId") String merchantId,
			@RequestHeader("MerchantKey") String merchantKey,
			//@RequestHeader("Content-Length") Integer content,
			@RequestBody Pedido p,
			@PathVariable String paymentId
			);

}




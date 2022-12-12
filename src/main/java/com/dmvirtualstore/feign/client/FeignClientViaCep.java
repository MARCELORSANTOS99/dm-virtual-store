package com.dmvirtualstore.feign.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.dmvirtualstore.config.FeignConfig;
import com.dmvirtualstore.domain.ViaCep;

@FeignClient(name="cep",url="https://viacep.com.br/ws/",configuration = FeignConfig.class)
public interface FeignClientViaCep {
			

	@GetMapping(value = "/{cep}/json",produces = MediaType.APPLICATION_JSON_VALUE)
	ViaCep buscarEndereco(@PathVariable String cep);

}




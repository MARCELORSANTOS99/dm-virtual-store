package com.dmvirtualstore.resources;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmvirtualstore.domain.APIResponse;
import com.dmvirtualstore.domain.Carrinho;
import com.dmvirtualstore.services.CarrinhoService;


@RestController
@RequestMapping(value="/carrinho")
public class CarrinhoResource {

		
	@Autowired
	private CarrinhoService service;

	
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<APIResponse> find(@PathVariable Integer id) {

		System.out.println("<<<>>>");
		System.out.println(id);
				
		Carrinho carrinho = service.findByCliente(id);
		
		APIResponse result = new APIResponse(carrinho);

		return ResponseEntity.ok().body(result);
	}
	
	
	@RequestMapping(value = "/teste", method = RequestMethod.GET)
	public ResponseEntity<APIResponse> finds() {

		System.out.println("<<<>>>");
		
		String teste = "teste";
		APIResponse result = new APIResponse(teste);

	
		return ResponseEntity.ok().body(result);
	}

	
}

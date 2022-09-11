package com.dmvirtualstore.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmvirtualstore.domain.APIResponse;
import com.dmvirtualstore.domain.Pedido;
import com.dmvirtualstore.services.PedidoService;

@RestController
@RequestMapping(value="/pedidos")
public class PedidoResource {

	@Autowired
	private PedidoService service;

	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {

		Pedido obj = service.buscar(id);
		
		APIResponse result = new APIResponse(obj);


		return ResponseEntity.ok().body(result);
	}

}

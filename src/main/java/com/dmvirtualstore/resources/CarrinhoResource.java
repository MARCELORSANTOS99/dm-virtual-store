package com.dmvirtualstore.resources;


import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmvirtualstore.domain.Carrinho;
import com.dmvirtualstore.domain.Produto;
import com.dmvirtualstore.dto.CarrinhoDTO;
import com.dmvirtualstore.dto.CarrinhoNewDTO;
import com.dmvirtualstore.services.CarrinhoService;
import com.dmvirtualstore.services.ProdutoService;


@RestController
@RequestMapping(value="/carrinho")
public class CarrinhoResource {

		
	@Autowired
	private CarrinhoService service;
	


	
	@RequestMapping(value = "/buscar/itens",method = RequestMethod.POST)
	public ResponseEntity<Carrinho> find(@RequestBody CarrinhoDTO objDto) {

		System.out.println("<<<BUSCAR CARRINHO>>>");
		System.out.println(objDto.getUserId());
				
		Carrinho carrinho = service.findByCliente(Integer.parseInt(objDto.getUserId()));
		
		System.out.println(carrinho.getCliente().getNome());
		//System.out.println(carrinho.getItems().get(0).getId());
		
		//APIResponse result = new APIResponse(carrinho);

		return ResponseEntity.ok().body(carrinho);
	}
	
	
	@RequestMapping(value = "/add/itens", method = RequestMethod.POST)
	public ResponseEntity<CarrinhoNewDTO> insert(@Valid @RequestBody CarrinhoNewDTO objDto){

		service.inserirProdutoNoCarrinho(objDto);
			
		return ResponseEntity.ok().body(objDto);
		
	}
	
	
	@RequestMapping(value = "/edit/itens", method = RequestMethod.POST)
	public ResponseEntity<CarrinhoNewDTO> update(@Valid @RequestBody CarrinhoNewDTO objDto){

		System.out.println("<<<1>>>");
		Carrinho carrinho = service.findByCliente(Integer.parseInt(objDto.getUserId()));		
		
		
		service.updateProdutoNoCarrinho(objDto);
							
			
		
		//APIResponse result = new APIResponse(obj);
		
		
		return ResponseEntity.ok().body(objDto);
		
	}
	


	
}

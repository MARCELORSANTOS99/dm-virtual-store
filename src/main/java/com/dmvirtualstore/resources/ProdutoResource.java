package com.dmvirtualstore.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dmvirtualstore.domain.APIResponse;
import com.dmvirtualstore.domain.Produto;
import com.dmvirtualstore.dto.ProdutoDTO;
import com.dmvirtualstore.services.ProdutoService;
import com.dmvirtualstore.services.utils.URL;


@RestController
@RequestMapping(value="/produtos")
public class ProdutoResource {

	@Autowired
	private ProdutoService service;

	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<Produto> find(@PathVariable Integer id) {

		Produto obj = service.find(id);

		return ResponseEntity.ok().body(obj);
	}

	@RequestMapping(value= "/page", method=RequestMethod.GET)
	public ResponseEntity<APIResponse> findPage(
			@RequestParam(value = "nome", defaultValue = "") String nome,
			@RequestParam(value = "categorias", defaultValue = "") String categorias,
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "title") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction
			){

		List<Integer> ids = URL.decodeIntList(categorias);
		String nomeDecode = URL.decodeParam(nome);

	 Page<Produto> list =  service.search(nomeDecode,ids, page,linesPerPage, orderBy, direction);

	 Page<ProdutoDTO> listDTO = list.map(obj -> new ProdutoDTO(obj));
	 
		APIResponse result = new APIResponse(listDTO);


	 return ResponseEntity.ok().body(result);
	}

}

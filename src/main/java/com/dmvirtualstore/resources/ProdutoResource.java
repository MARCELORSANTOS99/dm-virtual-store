package com.dmvirtualstore.resources;


import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dmvirtualstore.domain.APIResponse;
import com.dmvirtualstore.domain.Produto;
import com.dmvirtualstore.dto.ClienteDTO;
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
	
	
	@RequestMapping(value = "/all", method=RequestMethod.GET)
	public ResponseEntity<APIResponse> findAll() {
		List<Produto> list = service.findAll();

		APIResponse result = new APIResponse(list);

		return ResponseEntity.ok().body(result);
	}
	

	@RequestMapping(value= "/page", method=RequestMethod.GET)
	public ResponseEntity<APIResponse> findPage(
			@RequestHeader(value = "nome", defaultValue = "") String nome,
			@RequestHeader(value = "categorias", defaultValue = "0") String categorias,
			@RequestHeader(value = "page", defaultValue = "0") String page,
			@RequestHeader(value = "linesPerPage", defaultValue = "24") String linesPerPage,
			@RequestHeader(value = "orderBy", defaultValue = "title") String orderBy,
			@RequestHeader(value = "direction", defaultValue = "DESC") String direction
			){
		
		System.out.println("TENTOU BUSCAR PRODUTOS");

		Integer pageInt = Integer.parseInt(page);
		Integer linesPerPageInt = Integer.parseInt(linesPerPage);

		System.out.println("<<<mmmm>>>>");
				
		List<Integer> ids = URL.decodeIntList(categorias);
		if(ids.get(0) == 0) {
			ids.clear();
		}
		
		
		String nomeDecode = URL.decodeParam(nome.toLowerCase());

	 Page<Produto> list =  service.search(nomeDecode,ids, pageInt,linesPerPageInt, orderBy, direction);

	 //Page<ProdutoDTO> listDTO = list.map(obj -> new ProdutoDTO(obj));
	 
		APIResponse result = new APIResponse(list);


		 return ResponseEntity.ok().body(result);

	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public ResponseEntity<Produto> uploadProduto(
			@RequestParam(name="file") MultipartFile file,
			@RequestParam(name="title") String title,
			@RequestParam(name="price") String price,
			@RequestParam(name="description") String description,
			@RequestParam(name="unit") String unit
			){
		//URI uri = service.uploadProduto(file,objDto);
		
		
		Produto p = service.uploadProduto(file,title,price,description,unit);
		return ResponseEntity.ok(p);
	}

}

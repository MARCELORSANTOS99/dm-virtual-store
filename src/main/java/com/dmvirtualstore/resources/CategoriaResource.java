package com.dmvirtualstore.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmvirtualstore.domain.APIResponse;
import com.dmvirtualstore.domain.Categoria;

@RestController
@RequestMapping(value = "categorias")
public class CategoriaResource {
	
	@RequestMapping(method = RequestMethod.GET)
	public APIResponse listar() {
		
		Categoria cat1 = new Categoria(1, "Brincos");
		Categoria cat2 = new Categoria(1, "Colar");
		
		List<Categoria> lista = new ArrayList<>();
		
		
		lista.add(cat1);
		lista.add(cat2);
		
		APIResponse result = new APIResponse(lista);
		
		return result;
	}

}

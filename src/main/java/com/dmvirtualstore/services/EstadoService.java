package com.dmvirtualstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmvirtualstore.domain.Estado;
import com.dmvirtualstore.repositories.EstadoRepository;
import com.dmvirtualstore.services.exception.ObjectNotFoundException;

@Service
public class EstadoService {
	
	@Autowired
	private EstadoRepository repo;
	
	public List<Estado> findAll() {
		
		return repo.findAllByOrderByNome();
	}

	public Estado find(Integer id) {
		Optional<Estado> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Estado não encontrado! Id: " + id + ", Tipo: " + Estado.class.getName()));
	}

}

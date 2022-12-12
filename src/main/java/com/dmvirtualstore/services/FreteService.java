package com.dmvirtualstore.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dmvirtualstore.domain.Frete;
import com.dmvirtualstore.repositories.FreteRepository;




 
@Service
public class FreteService {
	
	@Autowired
	FreteRepository repo;

	public double calcularFrete(String cepObj) {
		
		Double freteValor;
		System.out.println("calcularFrete");
		System.out.println(cepObj);
		
		List<String> cepList = new ArrayList<String>(Arrays.asList(cepObj.split("-")));
		System.out.println(cepList);
		System.out.println(cepList.get(0));
		System.out.println(Integer.parseInt(cepList.get(0)));
		
		Integer cep = Integer.parseInt(cepList.get(0));
		
		Frete frete = repo.findFrete(cep);
		if(frete != null) {
			System.out.println(frete);
			freteValor = frete.getValor();
		}else {
			freteValor = 0.0;
		}
				
		return freteValor;
	}
}

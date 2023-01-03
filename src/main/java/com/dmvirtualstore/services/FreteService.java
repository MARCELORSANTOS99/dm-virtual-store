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
		System.out.println(cepObj);//04777-050
		
		String cep = formatarCep(cepObj);
		System.out.println(cep);//04777050
		
		Frete frete = repo.findFrete(Integer.parseInt(cep));
		System.out.println(frete);
		
		if(frete != null) {
			System.out.println(frete);
			freteValor = frete.getValor();
		}else {
			freteValor = 0.0;
		}
				
		return freteValor;
	}
	
	public static String formatarCep(String dado){
		   dado = dado.replaceAll("-","");
		   return dado;
		}
}

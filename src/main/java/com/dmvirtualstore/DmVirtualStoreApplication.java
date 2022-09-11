package com.dmvirtualstore;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dmvirtualstore.domain.Categoria;
import com.dmvirtualstore.repositories.CategoriaRepository;

@SpringBootApplication
public class DmVirtualStoreApplication implements CommandLineRunner {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DmVirtualStoreApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Ouro");
		Categoria cat2 = new Categoria(null, "Prata");


		categoriaRepository.saveAll(Arrays.asList(cat1, cat2)); 

	}

}

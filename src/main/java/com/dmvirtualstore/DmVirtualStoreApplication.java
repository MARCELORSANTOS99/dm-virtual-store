package com.dmvirtualstore;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dmvirtualstore.domain.Categoria;
import com.dmvirtualstore.domain.Produto;
import com.dmvirtualstore.repositories.CategoriaRepository;
import com.dmvirtualstore.repositories.ProdutoRepository;

@SpringBootApplication
public class DmVirtualStoreApplication implements CommandLineRunner {

	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ProdutoRepository produtoRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(DmVirtualStoreApplication.class, args);
	}
	
	
	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Ouro");
		Categoria cat2 = new Categoria(null, "Prata");
		
		Produto p1 = new Produto(null, "ANEL CRISTAL", 129.90, "ANEL CRISTAL VERDE EM PRATA 925 ESTERLINA - REGULÁVEL", "un", "https://images.yampi.me/assets/stores/oculosnow/uploads/images/anel-cristal-verde-em-prata-925-esterlina-regulavel-61983f365217a-medium.png");
		Produto p2 = new Produto(null, "Colar com Pingente", 0.01, "O colar com pingente coração 3D em ouro 18k é para todos os apaixonados, além de cair bem com todos os looks, pois é uma peça com pingente clássico!", "un", "https://virtualjoias.com/media/catalog/product/cache/2606ad8a2e237282be5631f3e1487bf0/c/o/colar-com-pingente-de-coracao-ouro-18k.jpg?quality=100");
		


		cat1.getProdutos().addAll(Arrays.asList(p1,p2));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1,cat2));
		


		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1,p2));


	}

}

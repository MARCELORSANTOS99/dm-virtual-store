package com.dmvirtualstore.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.time.LocalDateTime;
import java.util.Calendar;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.dmvirtualstore.domain.Categoria;
import com.dmvirtualstore.domain.Produto;
import com.dmvirtualstore.domain.enuns.Perfil;
import com.dmvirtualstore.repositories.CategoriaRepository;
import com.dmvirtualstore.repositories.ProdutoRepository;
import com.dmvirtualstore.security.UserSS;
import com.dmvirtualstore.services.exception.AuthorizationException;
import com.dmvirtualstore.services.exception.ObjectNotFoundException;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repo;
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private S3Service s3Service;
	
	@Autowired
	private ImageService imageService;
	
	@Value("${img.prefix.product.profile}")
	private String prefix;
	
	@Value("${img.product.size}")
	private Integer size;


	public Produto find(Integer id) { 
		 Optional<Produto> obj = repo.findById(id); 
		return obj.orElseThrow(() -> new ObjectNotFoundException( 
		 "Objeto não encontrado! Id: " + id + ", Tipo: " + Produto.class.getName())); 
		}

	public Page<Produto> search(String nome, List<Integer> ids, Integer page, Integer linesPerPage, String orderBy, String direction){

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);


		if(ids.isEmpty()) {
			List<Categoria> allCategorias = categoriaRepository.findAll();
			return repo.findDistinctByNomeContainingAndCategoriasIn(nome, allCategorias, pageRequest);
		}else {	
			List<Categoria> categorias = categoriaRepository.findAllById(ids);
			return repo.findDistinctByNomeContainingAndCategoriasIn(nome, categorias, pageRequest);
		}
		
		

		


	}
	
	public List<Produto> findAll() {

		repo.findAll();

		return repo.findAll();
	}
	
	
public Produto uploadProduto(MultipartFile multipartFile, String title,String price,String description,String unit) {
		
		UserSS user = UserService.authenticated();
		
		if(user==null || user.hasRole(Perfil.ADMIN)) {
			throw new AuthorizationException("Acesso negado");
		}
		
        LocalDateTime datetime = LocalDateTime.now();
		
		
		try {
			BufferedImage jpgImage =  imageService.getJpgImageFromFile(multipartFile);
			jpgImage = imageService.cropSquare(jpgImage);
			jpgImage = imageService.resize(jpgImage, size);
			
			String fileName = prefix + datetime + ".jpg";
			
			URI uri = s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
			
			Produto produto = new Produto(null,title,Double.parseDouble(price),description,unit,uri.toString());
			produto = repo.save(produto);
			
			return produto;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}

}

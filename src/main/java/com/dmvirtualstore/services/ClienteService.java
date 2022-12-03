package com.dmvirtualstore.services;

import java.awt.image.BufferedImage;
import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.dmvirtualstore.domain.Carrinho;
import com.dmvirtualstore.domain.Cliente;
import com.dmvirtualstore.domain.Endereco;
import com.dmvirtualstore.domain.ViaCep;
import com.dmvirtualstore.domain.enuns.Perfil;
import com.dmvirtualstore.domain.enuns.TipoCliente;
import com.dmvirtualstore.dto.ClienteDTO;
import com.dmvirtualstore.dto.ClienteNewDTO;
import com.dmvirtualstore.dto.EnderecoDTO;
import com.dmvirtualstore.feign.client.FeignClientViaCep;
import com.dmvirtualstore.repositories.CarrinhoRepository;
import com.dmvirtualstore.repositories.ClienteRepository;
import com.dmvirtualstore.security.UserSS;
import com.dmvirtualstore.services.exception.AuthorizationException;
import com.dmvirtualstore.services.exception.DataIntegrityException;
import com.dmvirtualstore.services.exception.ObjectNotFoundException;


@Service
public class ClienteService {
	
	@Autowired
	private S3Service s3Service;

	@Autowired
	private ClienteRepository repo;
	
	@Autowired
	private FeignClientViaCep clientViaCep;
	
	@Autowired
	private CarrinhoRepository carrinhoRepository;
	
	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private ImageService imageService;
	
	@Value("${img.profile.size}")
	private Integer size;
	
	
	@Value("${img.prefix.client.profile}")
	private String prefix;
	
	

	public Cliente find(Integer id) {
		
		UserSS user = UserService.authenticated();
						
		if(user==null || !user.hasRole(Perfil.ADMIN) && !id.equals(user.getId())) {
			throw new AuthorizationException("Acesso negado");
		}
		
		
		Optional<Cliente> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Cliente.class.getName()));
	}

	@Transactional
	public Cliente insert(Cliente obj) {
		System.out.println("Signup-> " + obj.getComplemento());
		obj.setId(null);
		carrinhoRepository.save(obj.getCarrinho());
		obj = repo.save(obj);
		return obj;
	}

	public Cliente fromDTO(ClienteNewDTO objDto) {
		
		Cliente cli = new Cliente(null,objDto.getNome(),objDto.getEmail(),objDto.getCpfOuCnpj(),TipoCliente.toEnum(objDto.getTipo()),pe.encode(objDto.getSenha()),objDto.getLogradouro(),objDto.getNumero(),objDto.getComplemento(),objDto.getBairro(),objDto.getCep(),objDto.getLocalidade(),objDto.getUf());
		
		
		Carrinho carrinho = new Carrinho(null, cli);
		
		cli.setCarrinho(carrinho);
		
		cli.getTelefones().add(objDto.getTelefone1());
		if (objDto.getTelefone2() != null) {
			cli.getTelefones().add(objDto.getTelefone2());
		}
		if (objDto.getTelefone3() != null) {
			cli.getTelefones().add(objDto.getTelefone3());
		}
		return cli;
	}
	
	public Cliente fromDTO(ClienteDTO objDto) {

		return new Cliente(objDto.getId(), objDto.getNome(), objDto.getEmail(), null, null, null, null, null, null, null, null, null, null);


	}
	
	public Cliente update(Cliente obj, boolean atualizarEndereco) {

		Cliente newObj = find(obj.getId());
		updateData(newObj,obj);
		

		return repo.save(newObj);
	}


	public void delete(Integer id) {
			find(id);

		try {
			repo.deleteById(id);

		} catch (DataIntegrityViolationException e) {

			throw new DataIntegrityException("Não é possível excluir um cliente que tem pedidos");


		}

	}
	
	
	public void buscarEnderecoViaCep(String cep) {
		
		ViaCep viaCep = clientViaCep.buscarEndereco(cep);
		
		Endereco end = new Endereco();
		
		end.setCep(viaCep.getCep());
		end.setLogradouro(viaCep.getLogradouro());
		end.setBairro(viaCep.getBairro());
		end.setBairro(viaCep.getBairro());
		

}

	public List<Cliente> findAll() {
		repo.findAll();
		return repo.findAll();
	}
	
	public Cliente findByEmail(String email) {
		UserSS user = UserService.authenticated();
		if (user == null || !user.hasRole(Perfil.ADMIN) && !email.equals(user.getUsername())) {
			throw new AuthorizationException("Acesso negado");
		}
	
		Cliente obj = repo.findByEmail(email);
		if (obj == null) {
			throw new ObjectNotFoundException(
					"Objeto não encontrado! Id: " + user.getId() + ", Tipo: " + Cliente.class.getName());
		}
		return obj;
	}


	public Page<Cliente> findPage(Integer page, Integer linesPerPage, String orderBy, String direction) {

		PageRequest pageRequest = PageRequest.of(page, linesPerPage, Direction.valueOf(direction), orderBy);

		return repo.findAll(pageRequest);
	}



	private void updateData(Cliente newObj, Cliente obj) {
		newObj.setNome(obj.getNome());
		newObj.setEmail(obj.getEmail());
	}
	
	public Cliente updateEndereco(Cliente obj, EnderecoDTO endereco) {
		
		if(endereco.getComplemento() !=null && !endereco.getComplemento().isEmpty()) {
			obj.setCep(endereco.getComplemento());
		}
		
		obj.setBairro(endereco.getBairro());
		obj.setCep(endereco.getCep());
		obj.setLocalidade(endereco.getLocalidade());
		obj.setNumero(endereco.getNumero());
		
		return repo.save(obj);

	}
	
public URI uploadPrfilePicture(MultipartFile multipartFile) {
		
		UserSS user = UserService.authenticated();
		
		if (user == null) {
			
			throw new AuthorizationException("Acesso negado");
		}
		
		BufferedImage jpgImage =  imageService.getJpgImageFromFile(multipartFile);
		jpgImage = imageService.cropSquare(jpgImage);
		jpgImage = imageService.resize(jpgImage, size);
		
		String fileName = prefix + user.getId() + ".jpg";
		
		return s3Service.uploadFile(imageService.getInputStream(jpgImage, "jpg"), fileName, "image");
		
	}



}

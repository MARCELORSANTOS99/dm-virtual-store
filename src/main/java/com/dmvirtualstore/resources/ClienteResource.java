package com.dmvirtualstore.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.dmvirtualstore.domain.APIResponse;
import com.dmvirtualstore.domain.Cliente;
import com.dmvirtualstore.dto.ClienteDTO;
import com.dmvirtualstore.dto.ClienteNewDTO;
import com.dmvirtualstore.security.JWTUtil;
import com.dmvirtualstore.services.ClienteService;

@RestController
@RequestMapping(value="/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService service;
	
	@Autowired
	private JWTUtil jwtUtil;
	
	
	@RequestMapping(value = "/{id}", method=RequestMethod.GET)
	public ResponseEntity<APIResponse> find(@PathVariable Integer id) {

		
		Cliente obj = service.find(id);
		
		APIResponse result = new APIResponse(obj);
		


		return ResponseEntity.ok().body(result);
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<ClienteNewDTO> insert(@Valid @RequestBody ClienteNewDTO objDto){

		Cliente obj = service.fromDTO(objDto);

		obj = service.insert(obj);
		
		/*
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(obj.getId()).toUri();
		*/		
		
		
		String token = jwtUtil.generateToken(obj.getEmail());
		
	    StringBuilder sb = new StringBuilder();
	    sb.append("Bearer " + token);
				
		
		objDto.setToken(sb.toString());
		objDto.setId(obj.getId().toString());;
		
		APIResponse result = new APIResponse(obj);
		
		
		return ResponseEntity.ok().body(objDto);
	}
	
	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@Valid @RequestBody ClienteDTO objDto, @PathVariable Integer id){

		Cliente obj = service.fromDTO(objDto);

		obj.setId(id);
		obj = service.update(obj);

		return ResponseEntity.noContent().build();
		}

	@RequestMapping(value = "/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
	
	@RequestMapping(value="/email", method=RequestMethod.GET)
	public ResponseEntity<Cliente> find(@RequestParam(value="value") String email) {
		Cliente obj = service.findByEmail(email);
		return ResponseEntity.ok().body(obj);
	}
	

	@RequestMapping( method=RequestMethod.GET)
	public ResponseEntity<List<ClienteDTO>> findAll(){
	 List<Cliente> list =  service.findAll();
	 List<ClienteDTO> listDTO = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());

	 return ResponseEntity.ok().body(listDTO);
	}

	@RequestMapping(value= "/page", method=RequestMethod.GET)
	public ResponseEntity<Page<ClienteDTO>> findPage(
			@RequestParam(value = "page", defaultValue = "0") Integer page,
			@RequestParam(value = "linesPerPage", defaultValue = "24") Integer linesPerPage,
			@RequestParam(value = "orderBy", defaultValue = "nome") String orderBy,
			@RequestParam(value = "direction", defaultValue = "DESC") String direction
			){
	 Page<Cliente> list =  service.findPage(page,linesPerPage, orderBy, direction);
	 Page<ClienteDTO> listDTO = list.map(obj -> new ClienteDTO(obj));

	 return ResponseEntity.ok().body(listDTO);
	}
	
	@RequestMapping(value="/picture", method = RequestMethod.POST)
	public ResponseEntity<Void> uploadProfilePicture(@RequestParam(name="file") MultipartFile file){
		URI uri = service.uploadPrfilePicture(file);
		return ResponseEntity.created(uri).build();
	}

}

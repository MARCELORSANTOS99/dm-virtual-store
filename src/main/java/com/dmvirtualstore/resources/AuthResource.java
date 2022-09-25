package com.dmvirtualstore.resources;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dmvirtualstore.domain.APIResponse;
import com.dmvirtualstore.dto.ClienteNewDTO;
import com.dmvirtualstore.dto.EmailDTO;
import com.dmvirtualstore.security.JWTUtil;
import com.dmvirtualstore.security.UserSS;
import com.dmvirtualstore.services.AuthService;
import com.dmvirtualstore.services.UserService;

@RestController
@RequestMapping(value = "/auth")
public class AuthResource {

	@Autowired
	private JWTUtil jwtUtil;

	@Autowired
	private AuthService service;

	

	@RequestMapping(value = "/refresh_token", method = RequestMethod.POST)
	public ResponseEntity<Void> refreshToken(HttpServletResponse response) {
		UserSS user = UserService.authenticated();
		String token = jwtUtil.generateToken(user.getUsername());
		response.addHeader("Authorization", "Bearer " + token);
		response.addHeader("access-control-expose-headers", "Authorization");
		return ResponseEntity.noContent().build();
	}

	@RequestMapping(value = "/validate_token", method = RequestMethod.POST)
	public ResponseEntity<APIResponse> validateToken(HttpServletResponse response) {
		
		
		System.out.println("<<< 1 >>>>");
		UserSS user = UserService.authenticated();

		String token = jwtUtil.generateToken(user.getUsername());
		 StringBuilder sb = new StringBuilder();
		    sb.append("Bearer " + token);
					
			ClienteNewDTO cliente = new ClienteNewDTO();
		    
			cliente.setId(user.getId().toString());
			cliente.setToken(sb.toString());
		
		System.out.println(token);
		System.out.println("<<< 2 >>>");

		APIResponse result = new APIResponse(cliente);
		//return ResponseEntity.noContent().build();
		return ResponseEntity.ok().body(result);

	}

	@RequestMapping(value = "/forgot", method = RequestMethod.POST)
	public ResponseEntity<Void> forgot(@Valid @RequestBody EmailDTO objDTO) {

		service.sendNewPassword(objDTO.getEmail());

		return ResponseEntity.noContent().build();
	}
}

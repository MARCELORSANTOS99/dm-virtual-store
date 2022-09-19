package com.dmvirtualstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dmvirtualstore.domain.Cliente;
import com.dmvirtualstore.repositories.ClienteRepository;
import com.dmvirtualstore.security.UserSS;



@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	
	@Autowired
	private ClienteRepository repo;
	

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

		Cliente cli = repo.findByEmail(email);
		if (cli == null) {
			throw new UsernameNotFoundException(email);
		}
		
		return new UserSS(cli.getId(), cli.getEmail(),cli.getSenha(), cli.getPerfis());
		
		
	}
	
	

}

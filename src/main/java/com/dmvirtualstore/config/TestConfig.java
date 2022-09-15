package com.dmvirtualstore.config;

import java.text.ParseException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.dmvirtualstore.services.DBServices;


@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBServices dbServices;
	
	@Bean
	public boolean instatiateDataBase() throws ParseException {
		
		dbServices.instatiateTestDataBase();
		return true;
	}
	
	/*
	@Bean
	public EmailService emailService() {
		return new MockEmailService();
	}
	*/

}

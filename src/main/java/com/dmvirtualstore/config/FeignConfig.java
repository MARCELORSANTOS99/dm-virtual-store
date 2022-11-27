package com.dmvirtualstore.config;

import org.springframework.context.annotation.Bean;

import feign.Logger;
import feign.auth.BasicAuthRequestInterceptor;

public class FeignConfig {
	   
    @Bean
    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
    	return new BasicAuthRequestInterceptor("teste", "teste2");
    }
    
    
}

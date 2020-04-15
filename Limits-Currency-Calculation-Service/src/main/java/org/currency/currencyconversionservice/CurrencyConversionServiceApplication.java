package org.currency.currencyconversionservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients("org.currency.currencyconversionservice")
@EnableDiscoveryClient
@EnableCircuitBreaker
public class CurrencyConversionServiceApplication {

	public static void main(String[] args) {
		System.setProperty("file.encoding", "UTF-8");
		SpringApplication.run(CurrencyConversionServiceApplication.class, args);
	}

	@Bean
	RestTemplate restTemplate(RestTemplateBuilder restTemplateBuilder) {		
	    return restTemplateBuilder
	    		.basicAuthentication("user", "password")	    	
	    		.build();
	}
}

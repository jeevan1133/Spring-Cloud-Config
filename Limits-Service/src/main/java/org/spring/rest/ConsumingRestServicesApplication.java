package org.spring.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.rest.beans.Configuration;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class ConsumingRestServicesApplication {

	private static final Logger log = LoggerFactory.getLogger(ConsumingRestServicesApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConsumingRestServicesApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Quote quote = restTemplate.getForObject(
					"https://gturnquist-quoters.cfapps.io/api/random", Quote.class);
			log.info(quote.toString());
		};
	}
	
	@Bean
	public Configuration getHelloWorldBean() {
		return new Configuration();
	}
}

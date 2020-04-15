package org.spring.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@EnableConfigServer 
@SpringBootApplication
public class LimitsSpringCouldConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(LimitsSpringCouldConfigServerApplication.class, args);
	}

}

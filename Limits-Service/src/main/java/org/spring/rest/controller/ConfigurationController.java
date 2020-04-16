package org.spring.rest.controller;

import org.spring.rest.beans.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigurationController {	
	
	@Autowired
	private Configuration configuration;

	@GetMapping("/hello")
	public String helloWorld() {
		return "Hello world!!!";
	}
	
	@GetMapping("/limits")
	public Configuration configuration() {
		return new Configuration(configuration.getMaximum(), configuration.getMinimum());
	}
}

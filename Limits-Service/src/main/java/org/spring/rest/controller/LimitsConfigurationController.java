package org.spring.rest.controller;

import org.spring.rest.configuration.Configuration;
import org.spring.rest.controller.beans.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LimitsConfigurationController {

	@Autowired
	private Configuration configuration;

	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsFromConfig() {
		log.info("IN limits class");

		return new LimitsConfiguration(configuration.getMaximum(),configuration.getMinimum());
	}
}

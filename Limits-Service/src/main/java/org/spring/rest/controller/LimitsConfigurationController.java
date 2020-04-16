package org.spring.rest.controller;

import org.spring.rest.configuration.LimitsConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class LimitsConfigurationController {

	@Autowired
	private LimitsConfiguration limitsConfiguration;

	@GetMapping("/limits")
	public LimitsConfiguration retrieveLimitsFromConfig() {
		log.info("IN limits class");

		return new LimitsConfiguration(limitsConfiguration.getMaximum(),limitsConfiguration.getMinimum());
	}
}
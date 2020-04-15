package org.spring.rest.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Data
@Component
@ConfigurationProperties("rest-service")
public class Configuration {
	
	private int minimum;
	private int maximum;

}

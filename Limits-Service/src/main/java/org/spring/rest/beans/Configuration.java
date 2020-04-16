package org.spring.rest.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("rest-service")
public class Configuration {
	
	private int maximum;
	private int minimum;
	
	public Configuration() {
		
	}

	public Configuration(int max, int min) {
		maximum = max;
		minimum = min;
	}
}

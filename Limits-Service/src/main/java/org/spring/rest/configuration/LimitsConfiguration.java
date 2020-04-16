package org.spring.rest.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

import lombok.Data;

@Data
@ConfigurationProperties("rest-service")
public class LimitsConfiguration {
	private int maximum;
	private int minimum;
	
	protected LimitsConfiguration() {	
	}
	
	public LimitsConfiguration(int max, int min) {
		maximum = max;
		minimum = min;
	}
}

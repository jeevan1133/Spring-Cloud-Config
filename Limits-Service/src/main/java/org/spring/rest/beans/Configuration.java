package org.spring.rest.beans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
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

	public int getMaximum() {
		return maximum;
	}

	public void setMaximum(int max) {
		maximum = max;
	}

	public void setMinimum(int min) {
		minimum = min;
	}

	public int getMinimum() {
		return minimum;
	}
}

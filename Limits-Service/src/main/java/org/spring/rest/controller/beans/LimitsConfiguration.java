package org.spring.rest.controller.beans;

import lombok.Data;

@Data
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

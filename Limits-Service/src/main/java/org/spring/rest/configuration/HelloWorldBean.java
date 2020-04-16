package org.spring.rest.controller.beans;

import lombok.Data;

@Data
public class HelloWorldBean {
	private String message;
	
	public HelloWorldBean(String msg) {
		this.message = msg;
	}
}

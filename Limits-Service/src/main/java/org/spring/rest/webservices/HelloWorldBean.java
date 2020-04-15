package org.spring.rest.webservices;

import lombok.Data;

@Data
public class HelloWorldBean {
	private String message;
	
	HelloWorldBean(String msg) {
		this.message = msg;
	}
}

package org.eureka.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
//import org.eureka.apigateway.ZuulLoggingFilter;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class NetlifxZuulApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(NetlifxZuulApiGatewayApplication.class, args);
	}

	@Bean
  public ZuulLoggingFilter zuulLogingFilter() {
	  return new ZuulLoggingFilter();
  }
}

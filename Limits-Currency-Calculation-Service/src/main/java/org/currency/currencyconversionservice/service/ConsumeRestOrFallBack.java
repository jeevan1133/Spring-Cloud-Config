package org.currency.currencyconversionservice.service;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.currency.currencyconversionservice.model.CurrencyConversionBean;
import org.currency.currencyconversionservice.proxy.CurrencyExchangeServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ConsumeRestOrFallBack {

	@Autowired
	private RestTemplate template;
	
	@Autowired
	private CurrencyExchangeServiceFeignClient feign;
	
	@HystrixCommand(fallbackMethod="getDefaultConversionResponse")
	public CurrencyConversionBean getConversion(String from, String to, BigDecimal quantity) {
		String url = "http://localhost:8001/currency-exchange/from/{from}/to/{to}";

		Map<String, String> urlVariables = new HashMap<String, String>();
		urlVariables.put("from", from);
		urlVariables.put("to", to);
		
		ResponseEntity<CurrencyConversionBean> responseEntity = template.getForEntity(url,
				CurrencyConversionBean.class, urlVariables);
		CurrencyConversionBean response = responseEntity.getBody();
		
		return new CurrencyConversionBean(response.getId(), from, to,
				response.getConversionMultiple(), quantity, 
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
	public CurrencyConversionBean getDefaultConversionResponse(String from, String to,
			 BigDecimal amount){
		return new CurrencyConversionBean("0", from, to, BigDecimal.ONE, BigDecimal.ONE.multiply(amount), BigDecimal.ZERO, -1);
	}
	
	@HystrixCommand(fallbackMethod="getDefaultConversionResponse")
	public CurrencyConversionBean useFeignClient(String from, String to, BigDecimal quantity) {
		// TODO Auto-generated method stub
		String authStr = "user:password";
	    String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());	    

		CurrencyConversionBean response = feign.retrieveExchangeValue("Basic " + base64Creds, from, to);
		
		return new CurrencyConversionBean(response.getId(), from, to,
				response.getConversionMultiple(), quantity, 
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
	
}

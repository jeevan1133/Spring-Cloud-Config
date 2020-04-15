package org.currency.currencyconversionservice.controller;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.currency.currencyconversionservice.model.CurrencyConversionBean;
import org.currency.currencyconversionservice.proxy.CurrencyExchangeServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private RestTemplate template;
	
	@Autowired
	private CurrencyExchangeServiceFeignClient feign;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity) {		
		String url = "http://localhost:8002/currency-exchange/from/{from}/to/{to}";

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
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign (@PathVariable String from, 
			@PathVariable String to, @PathVariable BigDecimal quantity) {
	    String authStr = "user:password";
	    String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());	    

		CurrencyConversionBean response = feign.retrieveExchangeValue("Basic " + base64Creds, from, to);
		
		return new CurrencyConversionBean(response.getId(), from, to,
				response.getConversionMultiple(), quantity, 
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}
}

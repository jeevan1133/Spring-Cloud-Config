package org.currency.currencyconversionservice.service;

import java.math.BigDecimal;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

import org.currency.currencyconversionservice.model.CurrencyConversionBean;
import org.currency.currencyconversionservice.proxy.CurrencyExchangeServiceFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Component
public class ConsumeRestOrFallBack implements GetOrFallBack{

	@Autowired
	private RestTemplate template;

	@Autowired
	private CurrencyExchangeServiceFeignClient feign;

	@Value("${REST.SERVICE.HOSTNAME:localhost}")
	private String host;

	@HystrixCommand(groupKey = "GetOrFallBack",
									fallbackMethod="getDefaultConversionResponse")
	public CurrencyConversionBean getConversion(String from, String to, BigDecimal quantity) {
		String url = "http://" + host + ":8001/currency-exchange/from/{from}/to/{to}";

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

	@HystrixCommand(groupKey = "GetOrFallBack",fallbackMethod="getDefaultConversionResponse")
	public CurrencyConversionBean useFeignClient(String from, String to, BigDecimal quantity) {
		// TODO Auto-generated method stub
		String authStr = "user:password";
	  String base64Creds = Base64.getEncoder().encodeToString(authStr.getBytes());
		System.out.println("Using Feign Client.....");
		CurrencyConversionBean response = feign.retrieveExchangeValue("Basic " + base64Creds, from, to);
	  // CurrencyConversionBean response = getConversion(from, to, quantity);
		return new CurrencyConversionBean(response.getId(), from, to,
				response.getConversionMultiple(), quantity,
				quantity.multiply(response.getConversionMultiple()), response.getPort());
	}

	public static CurrencyConversionBean getDefaultStaticConversionResponse(String from, String to, BigDecimal amount) {
		// TODO Auto-generated method stub
		ConsumeRestOrFallBack fallBack = new ConsumeRestOrFallBack();
		return fallBack.getDefaultConversionResponse(from, to, amount);

	}

}

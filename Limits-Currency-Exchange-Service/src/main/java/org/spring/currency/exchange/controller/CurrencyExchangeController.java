package org.spring.currency.exchange.controller;

import org.spring.currency.exchange.model.ExchangeValue;
import org.spring.currency.exchange.repository.ExchangeValueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyExchangeController {

	@Autowired
	private Environment environment;
	
	@Autowired
	private ExchangeValueRepository repository;

	@RequestMapping(value="/currency-exchange/from/{from}/to/{to}", method=RequestMethod.GET, produces={ MediaType.APPLICATION_JSON_VALUE})	
	public ExchangeValue retrieveExchangeValue(@PathVariable("from") String from, @PathVariable("to") String to) {
//		ExchangeValue exchangeValue = new ExchangeValue(1000L, from, to, BigDecimal.valueOf(65));
		ExchangeValue exchangeValue = repository.findByFromAndTo(from, to);
		exchangeValue.setPort(Integer.parseInt(environment.getProperty("local.server.port")));
		return exchangeValue;
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/")
	public String getHealth() {
		return "UP";
	}
}

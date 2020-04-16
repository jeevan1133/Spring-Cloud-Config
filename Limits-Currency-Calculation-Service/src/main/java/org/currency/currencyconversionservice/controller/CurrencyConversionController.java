package org.currency.currencyconversionservice.controller;

import java.math.BigDecimal;

import org.currency.currencyconversionservice.model.CurrencyConversionBean;
import org.currency.currencyconversionservice.service.ConsumeRestOrFallBack;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConversionController {

	@Autowired
	private ConsumeRestOrFallBack fallback;

	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrency(@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
		return fallback.getConversion(from, to, quantity);
	}

	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}")
	public CurrencyConversionBean convertCurrencyFeign (@PathVariable String from,
			@PathVariable String to, @PathVariable BigDecimal quantity) {
	  return fallback.useFeignClient(from, to, quantity);
	}
}

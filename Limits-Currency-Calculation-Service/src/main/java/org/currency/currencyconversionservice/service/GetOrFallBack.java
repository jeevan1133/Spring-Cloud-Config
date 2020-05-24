package org.currency.currencyconversionservice.service;

import org.currency.currencyconversionservice.model.CurrencyConversionBean;
import java.math.BigDecimal;

public interface GetOrFallBack {

  public CurrencyConversionBean getConversion(String from, String to, BigDecimal quantity);
  public CurrencyConversionBean getDefaultConversionResponse(String from, String to, BigDecimal amount);

  public CurrencyConversionBean useFeignClient(String from, String to, BigDecimal quantity);

}

	//package org.currency.currencyconversionservice.proxy;
	//
	//import org.currency.currencyconversionservice.model.CurrencyConversionBean;
	//import org.springframework.cloud.netflix.ribbon.RibbonClient;
	//import org.springframework.cloud.openfeign.FeignClient;
	//import org.springframework.web.bind.annotation.PathVariable;
	//import org.springframework.web.bind.annotation.RequestHeader;
	//import org.springframework.web.bind.annotation.RequestMapping;
	//import org.springframework.web.bind.annotation.RequestMethod;
	//
	////@FeignClient(name = "currency-exchange-service")
	////@FeignClient(name="netflix-zuul-api-gateway")
	//@FeignClient(name="zuulserver")
	////@RibbonClient(name = "currency-exchange-service")
	//@RibbonClient(name="exchangeservice") //, configuration=RibbonConfiguration.class)
	//public interface CurrencyExchangeServiceFeignClient {
	//
	//	@RequestMapping(method = RequestMethod.GET, value = "/currency-exchange/currency-exchange/from/{from}/to/{to}")
	//	public CurrencyConversionBean retrieveExchangeValue(
	//			@RequestHeader(value = "Authorization") String authorizationHeader,
	//			@PathVariable("from") String from,
	//			@PathVariable("to") String to);
	//}
	//
	//
	////
	////class HystrixClientFallback implements CurrencyExchangeServiceFeignClient {
	////
	////
	////	@Override
	////	public CurrencyConversionBean retrieveExchangeValue(String authorizationHeader, String from, String to) {
	////		// TODO Auto-generated method stub
	////		return ConsumeRestOrFallBack.getDefaultStaticConversionResponse(from, to, BigDecimal.ONE);
	////	}
	////
	////}

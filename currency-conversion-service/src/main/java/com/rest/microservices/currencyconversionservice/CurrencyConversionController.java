package com.rest.microservices.currencyconversionservice;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class CurrencyConversionController {
	
	@Autowired
	private CurrencyExchangeServiceProxy currencyExchangeProxy;
	
	@GetMapping("/currency-converter/from/{from}/to/{to}/quantity/{qty}")
	public CurrencyConverterBean convertCurrency(@PathVariable String from, 
			@PathVariable String to,
			@PathVariable BigDecimal qty)
	{	
		Map<String,String> uriVariable = new HashMap<>();
		uriVariable.put("from", from);
		uriVariable.put("to", to); 
		ResponseEntity<CurrencyConverterBean> responseEntity = new RestTemplate().getForEntity("http://localhost:8000/currency-exchange/from/{from}/to/{to}", CurrencyConverterBean.class,uriVariable);
	    CurrencyConverterBean response = responseEntity.getBody(); 
		return new CurrencyConverterBean(response.getId(), response.getFrom(), response.getTo(),response.getConversionMultiple(), qty,qty.multiply(response.getConversionMultiple()),response.getPort());
	}
	
	
	@GetMapping("/currency-converter-feign/from/{from}/to/{to}/quantity/{qty}")
	public CurrencyConverterBean convertCurrencyFeign(@PathVariable String from, 
			@PathVariable String to,
			@PathVariable BigDecimal qty)
	{		
		CurrencyConverterBean response= currencyExchangeProxy.retrieveExchangeValue(from, to);
		return new CurrencyConverterBean(response.getId(), response.getFrom(), response.getTo(),response.getConversionMultiple(), qty,qty.multiply(response.getConversionMultiple()),response.getPort());
	}
}

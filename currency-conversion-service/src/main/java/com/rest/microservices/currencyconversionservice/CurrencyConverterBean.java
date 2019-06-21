package com.rest.microservices.currencyconversionservice;

import java.math.BigDecimal;

public class CurrencyConverterBean {
	
	
	private Long id;
	private String from;
	private String to;
	private BigDecimal conversionMultiple;
	private BigDecimal qty;
	private BigDecimal totalCalcAmt;
	private int port;
	
	public CurrencyConverterBean() {
		super();
	}
	
	public CurrencyConverterBean(Long id, String from, String to, BigDecimal conversionMultiple, BigDecimal qty,
			BigDecimal totalCalcAmt, int port) {
		super();
		this.id = id;
		this.from = from;
		this.to = to;
		this.conversionMultiple = conversionMultiple;
		this.qty = qty;
		this.totalCalcAmt = totalCalcAmt;
		this.port = port;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public BigDecimal getConversionMultiple() {
		return conversionMultiple;
	}
	public void setConversionMultiple(BigDecimal conversionMultiple) {
		this.conversionMultiple = conversionMultiple;
	}
	public BigDecimal getQty() {
		return qty;
	}
	public void setQty(BigDecimal qty) {
		this.qty = qty;
	}
	public BigDecimal getTotalCalcAmt() {
		return totalCalcAmt;
	}
	public void setTotalCalcAmt(BigDecimal totalCalcAmt) {
		this.totalCalcAmt = totalCalcAmt;
	}
	public int getPort() {
		return port;
	}
	public void setPort(int port) {
		this.port = port;
	}
	

}

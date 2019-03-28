package com.stocks.view.model;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Stock {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String stockName;
	private BigDecimal openingPrice;
	private BigDecimal closingPrice;
	private BigDecimal dayhighPrice;
	private BigDecimal daylowPrice;
	
	public Stock() {
	}
	public Stock(String stockName) {
		super();
		this.stockName = stockName;
	}
	
	public Stock(String stockName, BigDecimal openingPrice, BigDecimal closingPrice, BigDecimal dayhighPrice,
			BigDecimal daylowPrice) {
		super();
		this.stockName = stockName;
		this.openingPrice = openingPrice;
		this.closingPrice = closingPrice;
		this.dayhighPrice = dayhighPrice;
		this.daylowPrice = daylowPrice;
	}
	public String getStockName() {
		return stockName;
	}
	public void setStockName(String stockName) {
		this.stockName = stockName;
	}
	public BigDecimal getOpeningPrice() {
		return openingPrice;
	}
	public void setOpeningPrice(BigDecimal openingPrice) {
		this.openingPrice = openingPrice;
	}
	public BigDecimal getClosingPrice() {
		return closingPrice;
	}
	public void setClosingPrice(BigDecimal closingPrice) {
		this.closingPrice = closingPrice;
	}
	public BigDecimal getDayhighPrice() {
		return dayhighPrice;
	}
	public void setDayhighPrice(BigDecimal dayhighPrice) {
		this.dayhighPrice = dayhighPrice;
	}
	public BigDecimal getDaylowPrice() {
		return daylowPrice;
	}
	public void setDaylowPrice(BigDecimal daylowPrice) {
		this.daylowPrice = daylowPrice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

}

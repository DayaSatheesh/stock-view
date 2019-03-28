package com.stocks.view.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.stocks.view.service.StockService;

@Controller
public class StockController {
	
	private StockService stockService;

	public StockController(StockService stockService) {
		super();
		this.stockService = stockService;
	}
	
	@RequestMapping(value="/stock/{id}", method=RequestMethod.GET)
	public String getStock(Model model, @PathVariable("id") Long id){
		model.addAttribute("stock", stockService.getStock(id).get());
		return "stocks";
	}
	
	@RequestMapping(value="/stocks/{name}", method=RequestMethod.GET)
	public String getStockNames(Model model, @PathVariable("name") String name){
		model.addAttribute("stocks", stockService.getStockNames(name));
		return "stocks";
	}
	

}

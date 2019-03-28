package com.stocks.view.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.stocks.view.model.Stock;
import com.stocks.view.repositories.StockRepository;

@Service
public class StockServiceImpl implements StockService {

	private StockRepository stockRepository;
	
	
	public StockServiceImpl(StockRepository stockRepository) {
		super();
		this.stockRepository = stockRepository;
	}

	@Override
	public List<String> getStockNames(String partialName) {
		List<String> stockNames = new ArrayList<String>();
		Iterable<Stock> stocks = stockRepository.findAll();
		
		stocks.forEach(stock -> {
			if(stock.getStockName().contains(partialName))
				stockNames.add(stock.getStockName());	
		});
		return stockNames;
	}

	@Override
	public Optional<Stock> getStock(Long id) {
		return stockRepository.findById(id);
	}

}

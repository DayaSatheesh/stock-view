package com.stocks.view.service;

import java.util.List;
import java.util.Optional;

import com.stocks.view.model.*;

public interface StockService {
	
	List<String> getStockNames(String partialName);
	
	Optional<Stock> getStock(Long id);

}

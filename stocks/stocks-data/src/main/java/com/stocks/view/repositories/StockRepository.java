package com.stocks.view.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.stocks.view.model.Stock;

public interface StockRepository extends CrudRepository<Stock, Long>{
	
	Optional<Stock> findByStockName(String stockName);
	
}

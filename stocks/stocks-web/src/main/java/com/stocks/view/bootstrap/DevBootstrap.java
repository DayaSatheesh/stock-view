package com.stocks.view.bootstrap;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.stocks.view.model.Stock;
import com.stocks.view.repositories.StockRepository;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

	private StockRepository stockRepo;
	
	public DevBootstrap(StockRepository stockRepo) {
		super();
		this.stockRepo = stockRepo;
	}

	@Override
	public void onApplicationEvent(ContextRefreshedEvent arg0) {
		initData();
	}
	
	private void initData(){
		Stock s = new Stock("TCS");
		Stock s1 = new Stock("Tech Mahindra");
		Stock s2 = new Stock("Capgemini");
		Stock s3 = new Stock("SBI");
		stockRepo.save(s);
		stockRepo.save(s1);
		stockRepo.save(s2);
		stockRepo.save(s3);
	}
	

}

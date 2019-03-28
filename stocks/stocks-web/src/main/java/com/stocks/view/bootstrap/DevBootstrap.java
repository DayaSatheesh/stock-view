package com.stocks.view.bootstrap;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

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
		try {
			initData();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initData() throws IOException{
		/*Stock s = new Stock("TCS");
		Stock s1 = new Stock("Tech Mahindra");
		Stock s2 = new Stock("Capgemini");
		Stock s3 = new Stock("SBI");
		stockRepo.save(s);
		stockRepo.save(s1);
		stockRepo.save(s2);
		stockRepo.save(s3);*/
		
		FileInputStream fileInputStream = new FileInputStream(new File("C:/Users/DayaSatheesh1/git/stock-view/stocks/stocks-web/src/main/resources/source/stock_database.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(fileInputStream));
		String line = null; 
		while((line = br.readLine()) != null){
			String[] arr = line.split(",");
			Stock s = new Stock(arr[0],new BigDecimal(arr[2]),new BigDecimal(arr[3]),new BigDecimal(arr[4]),new BigDecimal(arr[5]));
			stockRepo.save(s);
		}
	}
	

}

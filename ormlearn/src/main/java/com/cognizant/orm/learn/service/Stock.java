package com.cognizant.orm.learn.service;

import java.util.Date;
import java.util.List;

import com.cognizant.orm.learn.model.Stock;

public interface StockService {


	List<Stock> getAllStockDetails();

	List<Stock> findStockUsingCode(String code);

	List<Stock> findFBStockInSep21(String code, Date startDate, Date endDate);
	
	List<Stock> findGoogleStockGreaterThan1250(String code, double price);

	List<Stock> findTop3VolumeStock();

	List<Stock> findLowest3NetflixStocks(String code);
  
}

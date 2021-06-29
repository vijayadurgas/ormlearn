package com.cognizant.orm.learn.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.orm.learn.model.Stock;
import com.cognizant.orm.learn.repository.StockRepository;
import com.cognizant.orm.learn.service.StockService;


@Service
@Transactional
public class StockServiceImpl implements StockService {


        @Autowired
	private StockRepository stockRepo;
	
  
	@Override
	public List<Stock> getAllStockDetails() 
  	{
		return stockRepo.findAll();
	}

  
	@Override
	public List<Stock> findStockUsingCode(String code) 
	{
		return stockRepo.findStockByCode(code);
	}

  
	@Override
	public List<Stock> findFBStockInSep21(String code, Date startDate, Date endDate) 
	{
		return stockRepo.fbStockInSep21(code, startDate, endDate);
	}

	@Override
	public List<Stock> findGoogleStockGreaterThan1250(String code, double price) 
	{
		return stockRepo.googleStocks(code, price);
	}

	@Override
	public List<Stock> findTop3VolumeStock() 
	{
		return stockRepo.topVolume();
	}

	@Override
	public List<Stock> findLowest3NetflixStocks(String code)
	{	
		return stockRepo.lowNetflixStocks(code);
	}

}

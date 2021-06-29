package com.cognizant.orm.learn.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

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
	public List<Stock> findFBStockInSep19(String code, Date startDate, Date endDate) 
  {
		return stockRepo.fbStockInSep19(code, startDate, endDate);
	}



}

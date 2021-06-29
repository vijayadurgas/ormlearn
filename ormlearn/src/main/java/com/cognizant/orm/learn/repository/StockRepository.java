package com.cognizant.orm.learn.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.orm.learn.model.Stock;

@Repository
public interface StockRepository extends JpaRepository<Stock, Integer> {


	@Query("select s from Stock s where s.code like %:code% order by s.code ASC")
	List<Stock> findStockByCode(String code);


	@Query("select s from Stock s where s.code like %:code% and s.date between :startDate and :endDate")
	List<Stock> fbStockInSep19(String code, Date startDate, Date endDate);

}

package com.cognizant.ormlearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm.learn.model.Country;
import com.cognizant.orm.learn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
  
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;

	private static void testGetAllCountries() {

		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");

	}

	private static void getAllCountriesTest(String code) throws CountryNotFoundException {

		LOGGER.info("Start getAll");
		Country country = countryService.findCountryByCode(code);
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End getAll");

	}

	public static void testAddCountry() {
    
		LOGGER.info("Start add");
		Country country = new Country("SI", "SOUTH INDIA");
		countryService.addCountry(country);
		LOGGER.info("End add");
	}

	private static void testUpdateCountry(String code, String name) throws CountryNotFoundException {

		LOGGER.info("Start update");
		countryService.updateCountry(code, name);
		LOGGER.info("End update");

	}

	private static void testDeleteCountry(String code) {

		LOGGER.info("Start del");
		countryService.deleteCountry(code);
		LOGGER.info("End del");

	}
	
	private static void testFindCountry(String text) {
    
		LOGGER.info("Start find");
		List<Country> country = (List<Country>) countryService.findCountry(text);
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End find");
	}

	public static void main(String[] args) throws CountryNotFoundException {
    
    		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		LOGGER.info("Inside main");
		testGetAllCountries();
		getAllCountriesTest("IN");
		testAddCountry();
		getAllCountriesTest("AS");
		testUpdateCountry("SI", "SOUTH INDIA");
    		testFindCountry("SI");
		testDeleteCountry("SI");


	}

}

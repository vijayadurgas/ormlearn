package com.cognizant.orm.learn.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.orm.learn.model.Country;
import com.cognizant.orm.learn.repository.CountryRepository;
import com.cognizant.springlearn.service.exception.CountryNotFoundException;

@Service
public class CountryService {

	@Autowired
	CountryRepository countryRepository;

	@Transactional
	public List<Country> getAllCountries() {
		return countryRepository.findAll();
	}
	
	@Transactional
	public List<Country> findCountry(String text) 
	{
		return countryRepository.findCountryBy(text);

	}
	
	@Transactional
	public Country findCountryByCode(String countryCode) throws CountryNotFoundException 
	{
		Optional<Country> result = countryRepository.findById(countryCode);
		if (!result.isPresent()) 
		{
			throw new CountryNotFoundException("Country not found");
		}
		Country country = result.get();
		return country;
	}
	
	@Transactional
	public void addCountry(Country country) 
	{
		countryRepository.save(country);
	}
	
	@Transactional
	public void deleteCountry(String code) 
	{
		
		Country country = (Country) countryRepository.findById(code).get();
		countryRepository.delete(country);
	}

	@Transactional
	public void updateCountry(String code, String name) throws CountryNotFoundException 
	{
		
		Country country = (Country) countryRepository.findById(code).get();
		country.setName(name);
		countryRepository.save(country);

	}
	


}

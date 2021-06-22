package com.cognizant.orm.learn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.cognizant.orm.learn.model.Country;

@Repository
public interface CountryRepository extends JpaRepository<Country, String> {
  
  @Query("select c from country c where c.name like %?1% order by name")
  public List<Country> findByCountryWith(String text);

}

package com.cognizant.orm.learn.service.impl;

import javax.transaction.Transactional;

import com.cognizant.orm.learn.model.Skill;
import com.cognizant.orm.learn.repository.SkillRepository;
import com.cognizant.orm.learn.service.SkillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillServiceImpl implements SkillService {

	@Autowired
	private SkillRepository skillRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(SkillServiceImpl.class);

	@Transactional
	public Skill getById(int id) 
  {

		LOGGER.info("SkillService get by ID");
		return skillRepository.findById(id).get();
    
	}

  
	@Transactional
	public void save(Skill skill) 
  {

		LOGGER.info("SkillService Start save");
		skillRepository.save(skill);
		LOGGER.info("SkillService End save");

	}

}

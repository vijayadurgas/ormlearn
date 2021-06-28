package com.cognizant.orm.learn.service;

import org.springframework.stereotype.Service;
import com.cognizant.orm.learn.model.Skill;

@Service
public interface SkillService {

	public Skill getById(int id);

	public void save(Skill skill);

}

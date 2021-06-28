package com.cognizant.orm.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.orm.learn.model.Skill;

public interface SkillRepository extends JpaRepository<Skill, Integer> {

}

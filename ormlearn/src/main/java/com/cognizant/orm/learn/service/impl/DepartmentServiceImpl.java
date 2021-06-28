package com.cognizant.orm.learn.service.impl;

import javax.transaction.Transactional;

import com.cognizant.orm.learn.model.Department;
import com.cognizant.orm.learn.repository.DepartmentRepository;
import com.cognizant.orm.learn.service.DepartmentService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DepartmentServiceImpl implements DepartmentService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentServiceImpl.class);

	@Autowired
	public DepartmentRepository departmentRepository;

	@Transactional
	public Department getById(int id) 
       {
    
		LOGGER.info("DepartmentService get by ID");
		return departmentRepository.findById(id).get();
    
	}

	@Transactional
	public void save(Department department)
        {

		LOGGER.info("DepartmentService Start save");
		departmentRepository.save(department);
		LOGGER.info("DepartmentService End save");

	}
}

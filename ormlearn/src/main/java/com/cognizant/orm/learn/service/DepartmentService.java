package com.cognizant.orm.learn.services;

import org.springframework.stereotype.Service;
import com.cognizant.orm.learn.model.Department;

@Service
public interface DepartmentService {

	public Department getById(int id);

	public void save(Department department);

}

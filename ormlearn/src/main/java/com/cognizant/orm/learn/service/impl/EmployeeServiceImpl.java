package com.cognizant.orm.learn.service.impl;

import com.cognizant.orm.learn.model.Employee;
import com.cognizant.orm.learn.repository.EmployeeRepository;
import com.cognizant.orm.learn.service.EmployeeService;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);

	@Transactional(readOnly = true)
	public Employee getById(int id) {

		LOGGER.info("EmployeeService get by ID");
		Optional<Employee> emp = employeeRepository.findById(id);
		if (!emp.isPresent())
			LOGGER.info("Error");
		return emp.get();

	}
  
	@Transactional
	public void save(Employee employee) {

		LOGGER.info("EmployeeService Start save");
		Employee save = employeeRepository.save(employee);
		LOGGER.debug("Employee:{}", save);
		LOGGER.info("EmployeeService End save");

	}
	
	@Override
	public List<Employee> getAll() {
		// TODO Auto-generated method stub
		return employeeRepository.getAllPermanentEmployees();
	}
	
	@Override
	public double getAverageSalary() {
		// TODO Auto-generated method stub
		return employeeRepository.getAverageSalary();
	}

  
	@Override
	public double getAverageSalaryByDept(int id) {
		// TODO Auto-generated method stub
		return employeeRepository.getAverageSalary(id);
	}

	@Override
	public List<Employee> getAllEmployeesNative() {
		// TODO Auto-generated method stub
		return employeeRepository.getAllEmployeesNative();
	}
	
	
}

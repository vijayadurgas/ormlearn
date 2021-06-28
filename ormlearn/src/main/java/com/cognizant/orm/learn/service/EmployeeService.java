package com.cognizant.orm.learn.services;
import java.util.List;
import com.cognizant.orm.learn.model.Employee;

public interface EmployeeService {

	public Employee getById(int id);
	public void save(Employee employee);
	public List<Employee> getAll();
	public double getAverageSalary();
	public double getAverageSalaryByDept(int id);
	public List<Employee> getAllEmployeesNative();

}

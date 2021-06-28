package com.cognizant.ormlearn;

import java.math.BigDecimal;
import java.util.Date;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.orm.learn.model.Country;
import com.cognizant.orm.learn.service.CountryService;
import com.cognizant.springlearn.service.exception.CountryNotFoundException; 

import com.cognizant.ormlearnformapping.model.Department;
import com.cognizant.ormlearnformapping.model.Employee;
import com.cognizant.ormlearnformapping.model.Skill;
import com.cognizant.ormlearnformapping.services.DepartmentService;
import com.cognizant.ormlearnformapping.services.EmployeeService;
import com.cognizant.ormlearnformapping.services.SkillService;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class OrmLearnApplication {
  
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);
	private static CountryService countryService;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;

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
	
	private static void testGetEmployee() {

		LOGGER.info("Start GetEmployee");
		Employee employee = employeeService.getById(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End GetEmployee");

	}
	
	private static void testAddEmployee() {
		
		LOGGER.info("Start AddEmployee");
		Department department = departmentService.getById(1);
		Employee employee = Employee.builder().name("Vijayadurga").salary(BigDecimal.valueOf(40000)).permanent(true)
				.dateOfBirth(new Date(2021, 09, 20)).department(department).build();
		employeeService.save(employee);
		LOGGER.info("End AddEmployee");
	}

	private static void testUpdateEmployee() {

		LOGGER.info("Start UpdateEmployee");
		Employee employee = employeeService.getById(1);
		Department department = departmentService.getById(2);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.info("End UpdateEmployee");
	}

	private static void testGetDepartment() {
		
		LOGGER.info("Start GetDepartment");
		Department department = departmentService.getById(3);
		department.getEmployeeList().forEach(emp -> System.out.println(emp));
		LOGGER.info("End GetDepartment");
	}

	private static void testAddSkillToEmployee() {
		
		LOGGER.info("Start AddSkill");
		Employee employee = employeeService.getById(1);
		Skill skill = skillService.getById(2);
		employee.getSkillList().add(skill);
		employeeService.save(employee);
		LOGGER.info("End AddSkill");
	}

	private static void getAllPermanent() {
		
		LOGGER.info("Start AllPermanent");
		List<Employee> all = employeeService.getAll();
		LOGGER.debug("{}", all);
		LOGGER.info("End AllPermanent");
	}

	private static void getAverageSalary() {
		
		LOGGER.info("Start AverageSalary");
		double averageSalary = employeeService.getAverageSalary();
		LOGGER.debug("{}", averageSalary);
		LOGGER.info("End AverageSalary");
	}

	private static void getAverageSalaryByDept() {
		
		LOGGER.info("Start AverageSalary");
		double averageSalary = employeeService.getAverageSalaryByDept(3);
		LOGGER.debug("{}", averageSalary);
		LOGGER.info("End AverageSalary");
	}
	
	private static void usingNative(){
		
		LOGGER.info("Start usingNative");
		List<Employee> allEmployeesNative = employeeService.getAllEmployeesNative();
		LOGGER.debug("{}", allEmployeesNative);
		LOGGER.info("End usingNative");
	}

	public static void main(String[] args) throws CountryNotFoundException {
    
    		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		countryService = context.getBean(CountryService.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		LOGGER.info("Inside main");
		testGetAllCountries();
		getAllCountriesTest("IN");
		testAddCountry();
		getAllCountriesTest("AS");
		testUpdateCountry("SI", "SOUTH INDIA");
    		testFindCountry("SI");
		testDeleteCountry("SI");
		// testGetEmployee();
		// testAddEmployee();
		// testUpdateEmployee();
		// testGetDepartment();
		// testAddSkillToEmployee();
		// getAllPermanent();
		// getAverageSalary();
		// getAverageSalaryByDept();
		usingNative();


	}

}

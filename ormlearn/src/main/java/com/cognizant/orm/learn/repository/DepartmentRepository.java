package com.cognizant.orm.learn.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cognizant.orm.learn.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}

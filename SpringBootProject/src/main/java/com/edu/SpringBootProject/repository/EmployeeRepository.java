package com.edu.SpringBootProject.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edu.SpringBootProject.Entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

}

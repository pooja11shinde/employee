package com.edu.SpringBootProject.service;

import java.util.List;

import com.edu.SpringBootProject.Entity.Employee;

public interface EmployeeService {
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
	Employee getEmployeeById(long id);
	Employee updateEmployee(Employee employee, long id);
	Employee saveemployee(Employee employee);
}


package com.edu.SpringBootProject.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.edu.SpringBootProject.Entity.Employee;
import com.edu.SpringBootProject.exception.ResourceNotFound;
import com.edu.SpringBootProject.repository.EmployeeRepository;
import com.edu.SpringBootProject.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository employeeRepository;
	
	
	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}


	@Override
	public Employee saveEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}


	@Override
	public List<Employee> getAllEmployee() {
		return employeeRepository.findAll();
		
	}


	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if(employee.isPresent()) {
			return employee.get();
		}
		else {
          
			throw new ResourceNotFound("Employee","Id",id);
		}
		
	}


	@Override
	public Employee updateEmployee(Employee employee, long id) {
		Employee emp = new Employee();
	 try {
		   emp = employeeRepository.findById(id).orElseThrow(
				 ()-> 		 new ResourceNotFound("Employee","Id",id));
	} catch (ResourceNotFound e) {
		
		e.printStackTrace();
	}
	 emp.setFirstName(employee.getFirstName());
	 emp.setLastName(employee.getLastName());
	 emp.setEmail(employee.getEmail());
	 
	 employeeRepository.save(emp);
	return emp;
	}


	@Override
	public Employee saveemployee(Employee employee) {
		// TODO Auto-generated method stub
		return null;
	}


	



}

package com.edu.SpringBootProject.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edu.SpringBootProject.Entity.Employee;
import com.edu.SpringBootProject.service.EmployeeService;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}
	
	@PostMapping
	// saveEmployee(Employee obj)
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
		return new ResponseEntity<Employee>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
	}
	

	@GetMapping
	public List<Employee> getAllEmployee()
	{
		return employeeService.getAllEmployee();
	}
	
	@GetMapping("{id}")//4
	public ResponseEntity<Employee>getEmployeeById(@PathVariable("id") long id) {
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
	}
	
	@GetMapping("/employeeByFirstName/{firstName}")//john
	public List<Employee> getEmployeeByFirstName(@PathVariable("firstName")String firstName){
		return employeeService.getEmployeeByFirstName(firstName);//john
	}
	
	@GetMapping("/employeeByLastName/{lastName}")//doe
	public List<Employee> getEmployeeByLastName(@PathVariable("lastName") String lastName){
		return employeeService.getEmployeeByLastName(lastName);//deo
		
	}
	
		@GetMapping("/employeeByFirstNameAndLastName")
	public List<Employee> getEmployeeByFirstNameAndLastName(@RequestParam("firstName") String firstName, @RequestParam("lastName")  String lastName )
	{
		return employeeService.getEmployeeByFirstNameAndLastName(firstName, lastName);
		
	}
	

	@GetMapping("/employeeByFirstNameOrLastName")
	public List<Employee> getEmployeeByFirstNameOrLastName(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName")  String lastName )
	{
		return employeeService.getEmployeeByFirstNameOrLastName(firstName, lastName);
		
	}
	
	@GetMapping("/employeeByIds")
	public List<Employee> getEmployeesByIds(@RequestParam(value="id") List<Long> id){
		return  employeeService.getEmployeesById(id);
	}
	
	/*@GetMapping("/employeeByDepartment/{id}")
	public List<Employee> getemployeeByDepartment(@PathVariable("id") Long id){
		return employeeService.getEmployeeByDepartment(id);
		
	}*/
	
	@GetMapping("/employeeByDepartmentGroup")
	public List<Employee> getEmployeeByDepartmentGroup(){
		return employeeService.getEmployeeByDepartmentGroup();
	}
	
	@GetMapping("/employeeFullNameById/{id}")
	public Employee getEmployeeFullNameById( @PathVariable("id") long id){
		return employeeService.getEmployeeFullNameById(id);
	}
	
		@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id),HttpStatus.OK);
		
	}
		
	@GetMapping("/employeeInDescOrder")
	public List<Employee> getEmployeeInDescOrder(){
		return employeeService.getEmployeeInDescOrder();
	}

	// CRUD
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee record deleted ",HttpStatus.OK);
		
		}
	
}



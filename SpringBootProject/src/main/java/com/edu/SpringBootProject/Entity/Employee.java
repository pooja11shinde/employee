package com.edu.SpringBootProject.Entity;
import java.beans.Transient;

import javax.annotation.Generated;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employeeTbl")

public class Employee {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column
	private Long id;
	
	@Column(name="first_name")
	private String firstName;
	@Column(name="last_name")
	private String lastName;
	@Column(name="email")
	private String email;
	
	@Transient
	private int count;
	
	
	@OneToOne
	@JoinColumn(name="department")
	private Department department;
	
	@ManyToOne
	@JoinTable(name="project_employee", joinColumns= { @JoinColumn(name="employee_id")}, inverseJoinColumns= { @JoinColumn(name="project_id")})

    private Projects project;

	
	public Employee() {
		
	}

	public Employee(String firstName, String lastName) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Employee(Long id, String email) {
		super();
		this.id = id;
		this.email = email;
	}

	public Employee(int count, Department department) {
		super();
		this.count = count;
		this.department = department;
	}
	
	
	
	
	
}

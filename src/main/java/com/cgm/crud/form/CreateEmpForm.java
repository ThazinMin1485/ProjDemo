package com.cgm.crud.form;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import com.cgm.crud.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateEmpForm {
	@NotNull
	@NotEmpty(message="Name cannot be empty")
	private String name;
	
	@NotEmpty(message="Department cannot be empty")
	private String department;
	
	@NotEmpty(message="Email cannot be empty")
	private String email;
	
	private int salary;
	
	public CreateEmpForm() {
		super();
	}
	
	public CreateEmpForm(Employee emp) {
		this.name=emp.getName();
		this.department=emp.getDepartment();
		this.email=emp.getEmail();
		this.salary=emp.getSalary();
	}
	
}

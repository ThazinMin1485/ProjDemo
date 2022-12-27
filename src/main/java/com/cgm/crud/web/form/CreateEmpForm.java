package com.cgm.crud.web.form;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cgm.crud.persistence.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreateEmpForm {
	@NotNull
	@NotEmpty(message="Name cannot be empty!")
	private String name;
	
	@NotEmpty(message="Department cannot be empty!")
	private String department;
	
	@NotEmpty(message="Email cannot be empty!")
	private String email;
	
	@Min(value=150000)
	private int salary;
	
	@NotEmpty
	private String password;
	
	private String type;
	
	public CreateEmpForm() {
		super();
	}
	
	public CreateEmpForm(Employee emp) {
		this.name=emp.getName();
		this.department=emp.getDepartment();
		this.email=emp.getEmail();
		this.salary=emp.getSalary();
		this.password=emp.getPassword();
		this.type=emp.getType();
	}
	
}

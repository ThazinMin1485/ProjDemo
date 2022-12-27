package com.cgm.crud.bl.dto;

import com.cgm.crud.persistence.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class EmployeeDto {
	private int id;
	private String name;
	private String email;
	private String department;
	private int salary;
	private String password;
	private String type;

	public EmployeeDto(Employee emp) {
		if(emp==null) {
			emp=new Employee();
		}
		this.id=emp.getId();
		this.name=emp.getName();
		this.email=emp.getEmail();
		this.department=emp.getDepartment();
		this.salary=emp.getSalary();
		this.password=emp.getPassword();
		this.type=emp.getType();
	}
}

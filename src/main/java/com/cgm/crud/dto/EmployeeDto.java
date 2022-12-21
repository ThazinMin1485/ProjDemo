package com.cgm.crud.dto;

import com.cgm.crud.entity.Employee;

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

	public EmployeeDto(Employee emp) {
		super();
	}
}

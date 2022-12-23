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

	public EmployeeDto(Employee emp) {
		super();
	}
}

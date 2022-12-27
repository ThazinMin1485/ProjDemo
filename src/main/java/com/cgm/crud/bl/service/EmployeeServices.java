package com.cgm.crud.bl.service;

import java.util.List;

import com.cgm.crud.bl.dto.EmployeeDto;
import com.cgm.crud.persistence.entity.Employee;
import com.cgm.crud.web.form.CreateEmpForm;

public interface EmployeeServices {

	// add employee
	public void addEmp(CreateEmpForm empform);

	// get all employee
	public List<EmployeeDto> getAllEmp();

	// get employeee by id
	public Employee getById(int id);

	// update employee
	public void updateEmp(Employee emp);

	// delete employee
	public void deleteEmployee(int id);
	
	//get employee by email
	public EmployeeDto findByEmail(String email);
}

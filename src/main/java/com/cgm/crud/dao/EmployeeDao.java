package com.cgm.crud.dao;

import java.util.List;

import com.cgm.crud.entity.Employee;

public interface EmployeeDao {
	// add Employee
	public void addEmployee(Employee emp);

    //get all employee
	public List<Employee> getAllEmployee();

	// get employee by id
	public Employee getEmpById(int id);
	
	//update employee
	public void updateEmp(Employee emp);
	
	//delete employee
	public void deleteEmp(int id);
}

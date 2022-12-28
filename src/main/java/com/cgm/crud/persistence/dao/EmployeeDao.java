package com.cgm.crud.persistence.dao;

import java.util.List;

import com.cgm.crud.persistence.entity.Employee;

/**
 * <h2>EmployeeDao Class</h2>
 * <p>
 * Process for Displaying EmployeeDao
 * </p>
 * 
 * @author User
 *
 */
public interface EmployeeDao {
	// add Employee
	/**
	 * <h2>addEmployee</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param emp
	 * @return void
	 */
	public void addEmployee(Employee emp);

	// get all employee
	/**
	 * <h2>getAllEmployee</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return List<Employee>
	 */
	public List<Employee> getAllEmployee();

	// get employee by id
	/**
	 * <h2>getEmpById</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param id
	 * @return
	 * @return Employee
	 */
	public Employee getEmpById(int id);

	// update employee
	/**
	 * <h2>updateEmp</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param emp
	 * @return void
	 */
	public void updateEmp(Employee emp);

	// delete employee
	/**
	 * <h2>deleteEmp</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param id
	 * @return void
	 */
	public void deleteEmp(int id);

	// get employee by email
	/**
	 * <h2>findByEmail</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param email
	 * @return
	 * @return Employee
	 */
	public Employee findByEmail(String email);
}

package com.cgm.crud.bl.service;

import java.util.List;

import com.cgm.crud.bl.dto.EmployeeDto;
import com.cgm.crud.persistence.entity.Employee;
import com.cgm.crud.web.form.CreateEmpForm;

/**
 * <h2>EmployeeServices Class</h2>
 * <p>
 * Process for Displaying EmployeeServices
 * </p>
 * 
 * @author User
 *
 */
public interface EmployeeServices {

	// add employee
	/**
	 * <h2>addEmp</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param empform
	 * @return void
	 */
	public void addEmp(CreateEmpForm empform);

	// get all employee
	/**
	 * <h2>getAllEmp</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @return
	 * @return List<EmployeeDto>
	 */
	public List<EmployeeDto> getAllEmp();

	// get employeee by id
	/**
	 * <h2>getById</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param id
	 * @return
	 * @return Employee
	 */
	public Employee getById(int id);

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
	 * <h2>deleteEmployee</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param id
	 * @return void
	 */
	public void deleteEmployee(int id);

	// get employee by email
	/**
	 * <h2>findByEmail</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param email
	 * @return
	 * @return EmployeeDto
	 */
	public EmployeeDto findByEmail(String email);
}

package com.cgm.crud.bl.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

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

	/**
	 * <h2> doImportEmp</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param file
	 * @return
	 * @throws IOException
	 * @return String
	 */
	public String doImportEmp(MultipartFile file) throws IOException;
}

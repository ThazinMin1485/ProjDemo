package com.cgm.crud.bl.dto;

import com.cgm.crud.persistence.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <h2> EmployeeDto Class</h2>
 * <p>
 * Process for Displaying EmployeeDto
 * </p>
 * 
 * @author User
 *
 */
/**
 * <h2>Constructor for EmployeeDto</h2>
 * <p>
 * Constructor for EmployeeDto
 * </p>
 * 
 * @param id
 * @param name
 * @param email
 * @param department
 * @param salary
 * @param password
 * @param type
 */
@AllArgsConstructor
/**
 * <h2>getId</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return int
 */
/**
 * <h2>getName</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2>getEmail</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2>getDepartment</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2>getSalary</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return int
 */
/**
 * <h2>getPassword</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2>getType</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2>setId</h2>
 * <p>
 * 
 * </p>
 *
 * @param id
 * @return void
 */
/**
 * <h2>setName</h2>
 * <p>
 * 
 * </p>
 *
 * @param name
 * @return void
 */
/**
 * <h2>setEmail</h2>
 * <p>
 * 
 * </p>
 *
 * @param email
 * @return void
 */
/**
 * <h2>setDepartment</h2>
 * <p>
 * 
 * </p>
 *
 * @param department
 * @return void
 */
/**
 * <h2>setSalary</h2>
 * <p>
 * 
 * </p>
 *
 * @param salary
 * @return void
 */
/**
 * <h2>setPassword</h2>
 * <p>
 * 
 * </p>
 *
 * @param password
 * @return void
 */
/**
 * <h2>setType</h2>
 * <p>
 * 
 * </p>
 *
 * @param type
 * @return void
 */
/**
 * <h2>equals</h2>
 * <p>
 * 
 * </p>
 * 
 * @param o
 * @return
 */
/**
 * <h2>canEqual</h2>
 * <p>
 * 
 * </p>
 *
 * @param other
 * @return
 * @return boolean
 */
/**
 * <h2>hashCode</h2>
 * <p>
 * 
 * </p>
 * 
 * @return
 */
/**
 * <h2>toString</h2>
 * <p>
 * 
 * </p>
 * 
 * @return
 */
@Data
public class EmployeeDto {
	/**
	 * <h2>id</h2>
	 * <p>
	 * id
	 * </p>
	 */
	private int id;
	/**
	 * <h2>name</h2>
	 * <p>
	 * name
	 * </p>
	 */
	private String name;
	/**
	 * <h2>email</h2>
	 * <p>
	 * email
	 * </p>
	 */
	private String email;
	/**
	 * <h2>department</h2>
	 * <p>
	 * department
	 * </p>
	 */
	private String department;
	/**
	 * <h2>salary</h2>
	 * <p>
	 * salary
	 * </p>
	 */
	private int salary;
	/**
	 * <h2>password</h2>
	 * <p>
	 * password
	 * </p>
	 */
	private String password;
	/**
	 * <h2>type</h2>
	 * <p>
	 * type
	 * </p>
	 */
	private String type;

	/**
	 * <h2>Constructor for EmployeeDto</h2>
	 * <p>
	 * Constructor for EmployeeDto
	 * </p>
	 * 
	 * @param emp
	 */
	public EmployeeDto(Employee emp) {
		this.id = emp.getId();
		this.name = emp.getName();
		this.email = emp.getEmail();
		this.department = emp.getDepartment();
		this.salary = emp.getSalary();
		this.password = emp.getPassword();
		this.type = emp.getType();
	}
}

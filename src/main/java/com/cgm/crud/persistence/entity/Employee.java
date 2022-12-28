package com.cgm.crud.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

/**
 * <h2> Employee Class</h2>
 * <p>
 * Process for Displaying Employee
 * </p>
 * 
 * @author User
 *
 */
/**
 * <h2> getId</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return int
 */
/**
 * <h2> getName</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2> getEmail</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2> getDepartment</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2> getSalary</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return int
 */
/**
 * <h2> getPassword</h2>
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
@Getter
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
@Setter
@Entity
public class Employee {
	/**
	 * <h2>id</h2>
	 * <p>
	 * id
	 * </p>
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
}

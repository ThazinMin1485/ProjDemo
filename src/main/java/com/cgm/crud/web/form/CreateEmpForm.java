package com.cgm.crud.web.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cgm.crud.persistence.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <h2>CreateEmpForm Class</h2>
 * <p>
 * Process for Displaying CreateEmpForm
 * </p>
 * 
 * @author User
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateEmpForm {
	/**
	 * <h2>name</h2>
	 * <p>
	 * name
	 * </p>
	 */
	@NotNull
	@NotEmpty(message = "Name cannot be empty!")
	private String name;

	/**
	 * <h2>department</h2>
	 * <p>
	 * department
	 * </p>
	 */
	@NotEmpty(message = "Department cannot be empty!")
	private String department;

	/**
	 * <h2>email</h2>
	 * <p>
	 * email
	 * </p>
	 */
	@NotEmpty(message = "Email cannot be empty!")
	private String email;

	/**
	 * <h2>salary</h2>
	 * <p>
	 * salary
	 * </p>
	 */
	@Min(value = 150000)
	private int salary;

	/**
	 * <h2>password</h2>
	 * <p>
	 * password
	 * </p>
	 */
	@NotEmpty
	private String password;

	/**
	 * <h2>type</h2>
	 * <p>
	 * type
	 * </p>
	 */
	private String type;

	/**
	 * <h2>Constructor for CreateEmpForm</h2>
	 * <p>
	 * Constructor for CreateEmpForm
	 * </p>
	 * 
	 * @param emp
	 */
	public CreateEmpForm(Employee emp) {
		this.name = emp.getName();
		this.department = emp.getDepartment();
		this.email = emp.getEmail();
		this.salary = emp.getSalary();
		this.password = emp.getPassword();
		this.type = emp.getType();
	}

}

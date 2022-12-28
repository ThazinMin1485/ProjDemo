package com.cgm.crud.web.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.cgm.crud.persistence.entity.Employee;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * <h2> CreateEmpForm Class</h2>
 * <p>
 * Process for Displaying CreateEmpForm
 * </p>
 * 
 * @author User
 *
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
 * <h2> getDepartment</h2>
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
 * <h2> getType</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2> setName</h2>
 * <p>
 * 
 * </p>
 *
 * @param name
 * @return void
 */
/**
 * <h2> setDepartment</h2>
 * <p>
 * 
 * </p>
 *
 * @param department
 * @return void
 */
/**
 * <h2> setEmail</h2>
 * <p>
 * 
 * </p>
 *
 * @param email
 * @return void
 */
/**
 * <h2> setSalary</h2>
 * <p>
 * 
 * </p>
 *
 * @param salary
 * @return void
 */
/**
 * <h2> setPassword</h2>
 * <p>
 * 
 * </p>
 *
 * @param password
 * @return void
 */
/**
 * <h2> setType</h2>
 * <p>
 * 
 * </p>
 *
 * @param type
 * @return void
 */
/**
 * <h2> equals </h2>
 * <p>
 * 
 * </p>
 * 
 * @param o
 * @return
 */
/**
 * <h2> canEqual</h2>
 * <p>
 * 
 * </p>
 *
 * @param other
 * @return
 * @return boolean
 */
/**
 * <h2> hashCode </h2>
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
/**
 * <h2>Constructor for CreateEmpForm</h2>
 * <p>
 * Constructor for CreateEmpForm
 * </p>
 * 
 * @param name
 * @param department
 * @param email
 * @param salary
 * @param password
 * @param type
 */
@AllArgsConstructor
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
	 */
	public CreateEmpForm() {
		super();
	}

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

package com.cgm.crud.persistence.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Getter
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

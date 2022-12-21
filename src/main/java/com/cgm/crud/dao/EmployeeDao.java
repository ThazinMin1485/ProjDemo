package com.cgm.crud.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cgm.crud.entity.Employee;

@Repository
public class EmployeeDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	private SessionFactory sessionFactory;

	// add employee
	@Transactional
	public void addEmployee(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
	}

	// get all employee
	public List<Employee> getAllEmployee() {
		return hibernateTemplate.loadAll(Employee.class);
	}

	// get employee by id
	@Transactional
	public Employee getEmpById(int id) {
		Employee emp = hibernateTemplate.get(Employee.class, id);
		return emp;
	}

	// update employee
	@Transactional
	public void updateEmp(Employee emp) {
		hibernateTemplate.update(emp);
	}

	// delete employee
	@Transactional
	public void deleteEmp(int id) {
		hibernateTemplate.delete(hibernateTemplate.load(Employee.class, id));
	}
}

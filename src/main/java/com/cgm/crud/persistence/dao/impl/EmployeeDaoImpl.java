package com.cgm.crud.persistence.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.cgm.crud.persistence.dao.EmployeeDao;
import com.cgm.crud.persistence.entity.Employee;

@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	@Autowired
	HibernateTemplate hibernateTemplate;
	@Autowired
	private SessionFactory sessionFactory;

	// add employee
	@Override
	public void addEmployee(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
	}

	// get all employee
	@Override
	public List<Employee> getAllEmployee() {
		return hibernateTemplate.loadAll(Employee.class);
	}

	// get employee by id
	@Override
	public Employee getEmpById(int id) {
		Employee emp = hibernateTemplate.get(Employee.class, id);
		return emp;
	}

	// update employee
	@Override
	public void updateEmp(Employee emp) {
		hibernateTemplate.update(emp);
	}

	// delete employee
	@Override
	public void deleteEmp(int id) {
		hibernateTemplate.delete(hibernateTemplate.load(Employee.class, id));
	}

	// get employee by email
	@SuppressWarnings("rawtypes")
	public Employee findByEmail(String email) {
		String userQuery = "SELECT e FROM Employee e WHERE e.email=:email ";
		Query query = this.sessionFactory.getCurrentSession().createQuery(userQuery);
		query.setParameter("email", email);
		Employee emp = (Employee) query.uniqueResult();
		return emp;
	}
}

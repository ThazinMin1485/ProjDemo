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

/**
 * <h2> EmployeeDaoImpl Class</h2>
 * <p>
 * Process for Displaying EmployeeDaoImpl
 * </p>
 * 
 * @author User
 *
 */
@Repository
@Transactional
public class EmployeeDaoImpl implements EmployeeDao {
	/**
	 * <h2> hibernateTemplate</h2>
	 * <p>
	 * hibernateTemplate
	 * </p>
	 */
	@Autowired
	HibernateTemplate hibernateTemplate;
	/**
	 * <h2> sessionFactory</h2>
	 * <p>
	 * sessionFactory
	 * </p>
	 */
	@Autowired
	private SessionFactory sessionFactory;

	// add employee
	/**
	 * <h2> addEmployee </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param emp
	 */
	@Override
	public void addEmployee(Employee emp) {
		sessionFactory.getCurrentSession().save(emp);
	}

	// get all employee
	/**
	 * <h2> getAllEmployee </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @return
	 */
	@Override
	public List<Employee> getAllEmployee() {
		return hibernateTemplate.loadAll(Employee.class);
	}

	// get employee by id
	/**
	 * <h2> getEmpById </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param id
	 * @return
	 */
	@Override
	public Employee getEmpById(int id) {
		Employee emp = hibernateTemplate.get(Employee.class, id);
		return emp;
	}

	// update employee
	/**
	 * <h2> updateEmp </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param emp
	 */
	@Override
	public void updateEmp(Employee emp) {
		hibernateTemplate.update(emp);
	}

	// delete employee
	/**
	 * <h2> deleteEmp </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param id
	 */
	@Override
	public void deleteEmp(int id) {
		hibernateTemplate.delete(hibernateTemplate.load(Employee.class, id));
	}

	// get employee by email
	/**
	 * <h2> findByEmail </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param email
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public Employee findByEmail(String email) {
		String userQuery = "SELECT e FROM Employee e WHERE e.email=:email ";
		Query query = this.sessionFactory.getCurrentSession().createQuery(userQuery);
		query.setParameter("email", email);
		Employee emp = (Employee) query.uniqueResult();
		return emp;
	}
}

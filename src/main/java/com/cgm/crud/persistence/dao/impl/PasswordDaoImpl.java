package com.cgm.crud.persistence.dao.impl;

import javax.transaction.Transactional;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.cgm.crud.persistence.dao.PasswordDao;
import com.cgm.crud.persistence.entity.PasswordReset;

/**
 * <h2> PasswordDaoImpl Class</h2>
 * <p>
 * Process for Displaying PasswordDaoImpl
 * </p>
 * 
 * @author User
 *
 */
@Repository
@Transactional
public class PasswordDaoImpl implements PasswordDao {

	/**
	 * <h2> sessionFactory</h2>
	 * <p>
	 * sessionFactory
	 * </p>
	 */
	@Autowired
	private SessionFactory sessionFactory;

	/**
	 * <h2> getTokenDataByEmail </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param email
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public PasswordReset getTokenDataByEmail(String email) {
		String query = "SELECT pw FROM PasswordReset pw WHERE pw.email= :email";
		Query queryEmail = this.sessionFactory.getCurrentSession().createQuery(query);
		queryEmail.setParameter("email", email);
		PasswordReset passwordReset = (PasswordReset) queryEmail.uniqueResult();
		return passwordReset;
	}

	/**
	 * <h2> deleteToken </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param email
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public void deleteToken(String email) {
		String query = "DELETE FROM PasswordReset pw WHERE pw.email= :email";
		Query q = this.sessionFactory.getCurrentSession().createQuery(query);
		q.setParameter("email", email);
		q.executeUpdate();
	}

	/**
	 * <h2> createToken </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param pwToken
	 */
	@Override
	public void createToken(PasswordReset pwToken) {
		sessionFactory.getCurrentSession().save(pwToken);
	}

	/**
	 * <h2> dbGetDataByToken </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param token
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public PasswordReset dbGetDataByToken(String token) {
		String query = "SELECT pw FROM PasswordReset pw WHERE pw.token= :token";
		Query q=this.sessionFactory.getCurrentSession().createQuery(query);
		q.setParameter("token", token);
		PasswordReset passReset=(PasswordReset) q.uniqueResult();
		return passReset;
	}

}

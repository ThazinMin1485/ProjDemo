package com.cgm.crud.bl.service.impl;


import java.sql.Date;
import java.sql.Timestamp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cgm.crud.bl.service.PasswordServices;
import com.cgm.crud.common.Constant;
import com.cgm.crud.common.TokenGenerator;
import com.cgm.crud.persistence.dao.EmployeeDao;
import com.cgm.crud.persistence.dao.PasswordDao;
import com.cgm.crud.persistence.entity.Employee;
import com.cgm.crud.persistence.entity.PasswordReset;
import com.cgm.crud.web.form.ResetForm;

/**
 * <h2> PasswordServicesImpl Class</h2>
 * <p>
 * Process for Displaying PasswordServicesImpl
 * </p>
 * 
 * @author User
 *
 */
@Transactional
@Service
public class PasswordServicesImpl implements PasswordServices{

	/**
	 * <h2> now</h2>
	 * <p>
	 * now
	 * </p>
	 */
	private Timestamp now=new Timestamp(new Date(System.currentTimeMillis()).getTime());

	/**
	 * <h2> pwDao</h2>
	 * <p>
	 * pwDao
	 * </p>
	 */
	@Autowired
	private PasswordDao pwDao;
	
	/**
	 * <h2> empDao</h2>
	 * <p>
	 * empDao
	 * </p>
	 */
	@Autowired
	private EmployeeDao empDao;
	
	/**
	 * <h2> pwEncoder</h2>
	 * <p>
	 * pwEncoder
	 * </p>
	 */
	@Autowired
	private PasswordEncoder pwEncoder;
	
	/**
	 * <h2> createResetToken </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param email
	 * @return
	 */
	@Override
	public ResetForm createResetToken(String email) {
		PasswordReset pwToken= pwDao.getTokenDataByEmail(email);
		
		//delete token
		if(pwToken!=null) {
			pwDao.deleteToken(email);
		}
		
		//for token
		String token=new TokenGenerator(Constant.PSW_TOKEN_LENGTH).getToken();
		
		// for token expire
        Timestamp expired = new Timestamp(
                new Date(System.currentTimeMillis() + Constant.PSW_TOKEN_EPIRE_MINUTE * 60 * 1000).getTime());
        
     // save to database
        ResetForm resetForm = new ResetForm();
        resetForm.setEmail(email);
        resetForm.setToken(token);
        resetForm.setCreated_at(now);
        resetForm.setExpired_at(expired);

        pwDao.createToken(this.getPasswordToken(resetForm));

        return resetForm;
		
	}
	
	/**
	 * <h2> getDataByToken </h2>
	 * <p>
	 * 
	 * </p>
	 * 
	 * @param token
	 * @return
	 */
	@Override
    public ResetForm getDataByToken(String token) {
        PasswordReset pw = pwDao.dbGetDataByToken(token);
        if (pw == null) {
            return null;
        }

        ResetForm reset = new ResetForm(pw);
        return reset;
    }

    /**
     * <h2> deleteToken </h2>
     * <p>
     * 
     * </p>
     * 
     * @param email
     */
    public void deleteToken(String email) {
        pwDao.deleteToken(email);
    }

    /**
     * <h2> updatePassword </h2>
     * <p>
     * 
     * </p>
     * 
     * @param resetForm
     */
    @Override
    public void updatePassword(ResetForm resetForm) {
        resetForm.setPassword(pwEncoder.encode(resetForm.getPassword()));

        String email = resetForm.getEmail();
        Employee emp = empDao.findByEmail(email);

        emp.setPassword(resetForm.getPassword());

        empDao.updateEmp(emp);
    }

	
	/**
	 * <h2> getPasswordToken</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param resetForm
	 * @return
	 * @return PasswordReset
	 */
	private PasswordReset getPasswordToken(ResetForm resetForm) {
        PasswordReset pwToken = new PasswordReset();
        pwToken.setEmail(resetForm.getEmail());
        pwToken.setToken(resetForm.getToken());
        pwToken.setCreated_at(resetForm.getCreated_at());
        pwToken.setExpired_at(resetForm.getExpired_at());
        return pwToken;
    }
}

package com.cgm.crud.bl.service;

import com.cgm.crud.web.form.ResetForm;

/**
 * <h2> PasswordServices Class</h2>
 * <p>
 * Process for Displaying PasswordServices
 * </p>
 * 
 * @author User
 *
 */
public interface PasswordServices {

	/**
	 * <h2> createResetToken</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param email
	 * @return
	 * @return ResetForm
	 */
	ResetForm createResetToken(String email);

	/**
	 * <h2> updatePassword</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param resetForm
	 * @return void
	 */
	void updatePassword(ResetForm resetForm);

	/**
	 * <h2> getDataByToken</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param token
	 * @return
	 * @return ResetForm
	 */
	ResetForm getDataByToken(String token);
	
	/**
	 * <h2> deleteToken</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param email
	 * @return void
	 */
	void deleteToken(String email);

}

package com.cgm.crud.persistence.dao;

import com.cgm.crud.persistence.entity.PasswordReset;

/**
 * <h2> PasswordDao Class</h2>
 * <p>
 * Process for Displaying PasswordDao
 * </p>
 * 
 * @author User
 *
 */
public interface PasswordDao {

	/**
	 * <h2> getTokenDataByEmail</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param email
	 * @return
	 * @return PasswordReset
	 */
	PasswordReset getTokenDataByEmail(String email);

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

	/**
	 * <h2> createToken</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param pwReset
	 * @return void
	 */
	void createToken(PasswordReset pwReset);

	/**
	 * <h2> dbGetDataByToken</h2>
	 * <p>
	 * 
	 * </p>
	 *
	 * @param token
	 * @return
	 * @return PasswordReset
	 */
	PasswordReset dbGetDataByToken(String token);

}

package com.cgm.crud.web.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

/**
 * <h2> ResetPasswordForm Class</h2>
 * <p>
 * Process for Displaying ResetPasswordForm
 * </p>
 * 
 * @author User
 *
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
 * <h2> getToken</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
/**
 * <h2> getConfirm_password</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return String
 */
@Getter
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
 * <h2> setToken</h2>
 * <p>
 * 
 * </p>
 *
 * @param token
 * @return void
 */
/**
 * <h2> setConfirm_password</h2>
 * <p>
 * 
 * </p>
 *
 * @param confirm_password
 * @return void
 */
@Setter
public class ResetPasswordForm {

	/**
	 * <h2> password</h2>
	 * <p>
	 * password
	 * </p>
	 */
	@NotEmpty
	@Size(min = 6, max = 12)
	private String password;
	/**
	 * <h2> token</h2>
	 * <p>
	 * token
	 * </p>
	 */
	private String token;

	/**
	 * <h2> confirm_password</h2>
	 * <p>
	 * confirm_password
	 * </p>
	 */
	private String confirm_password;

	/**
	 * <h2> Constructor for ResetPasswordForm </h2>
	 * <p>
	 * Constructor for ResetPasswordForm
	 * </p>
	 */
	public ResetPasswordForm() {
		super();
	}
}

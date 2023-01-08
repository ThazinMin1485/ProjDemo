package com.cgm.crud.web.form;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.cgm.crud.persistence.entity.PasswordReset;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * <h2>ResetForm Class</h2>
 * <p>
 * Process for Displaying ResetForm
 * </p>
 * 
 * @author User
 *
 */
@Getter
@Setter
@NoArgsConstructor
public class ResetForm {

	/**
	 * <h2>email</h2>
	 * <p>
	 * email
	 * </p>
	 */
	@Email
	@NotEmpty
	private String email;

	/**
	 * <h2>password</h2>
	 * <p>
	 * password
	 * </p>
	 */
	private String password;

	/**
	 * <h2>token</h2>
	 * <p>
	 * token
	 * </p>
	 */
	private String token;
	/**
	 * <h2>created_at</h2>
	 * <p>
	 * created_at
	 * </p>
	 */
	private Timestamp created_at;
	/**
	 * <h2>expired_at</h2>
	 * <p>
	 * expired_at
	 * </p>
	 */
	private Timestamp expired_at;

	/**
	 * <h2>Constructor for ResetForm</h2>
	 * <p>
	 * Constructor for ResetForm
	 * </p>
	 * 
	 * @param passReset
	 */
	public ResetForm(PasswordReset passReset) {
		this.email = passReset.getEmail();
		this.token = passReset.getToken();
		this.created_at = passReset.getCreated_at();
		this.expired_at = passReset.getExpired_at();
	}
}

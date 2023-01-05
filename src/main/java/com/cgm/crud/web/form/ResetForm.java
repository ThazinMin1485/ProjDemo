package com.cgm.crud.web.form;

import java.sql.Timestamp;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import com.cgm.crud.persistence.entity.PasswordReset;

import lombok.Getter;
import lombok.Setter;

/**
 * <h2> ResetForm Class</h2>
 * <p>
 * Process for Displaying ResetForm
 * </p>
 * 
 * @author User
 *
 */
/**
 * <h2> getEmail</h2>
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
 * <h2> getCreated_at</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return Timestamp
 */
/**
 * <h2>getExpired_at</h2>
 * <p>
 * 
 * </p>
 *
 * @return
 * @return Timestamp
 */
/**
 * <h2> ResetForm Class</h2>
 * <p>
 * Process for Displaying ResetForm
 * </p>
 * 
 * @author User
 *
 */
/**
 * <h2> ResetForm Class</h2>
 * <p>
 * Process for Displaying ResetForm
 * </p>
 * 
 * @author User
 *
 */
/**
 * <h2> ResetForm Class</h2>
 * <p>
 * Process for Displaying ResetForm
 * </p>
 * 
 * @author User
 *
 */
@Getter
/**
 * <h2>setEmail</h2>
 * <p>
 * 
 * </p>
 *
 * @param email
 * @return void
 */
/**
 * <h2>setToken</h2>
 * <p>
 * 
 * </p>
 *
 * @param token
 * @return void
 */
/**
 * <h2>setCreated_at</h2>
 * <p>
 * 
 * </p>
 *
 * @param created_at
 * @return void
 */
/**
 * <h2>setExpired_at</h2>
 * <p>
 * 
 * </p>
 *
 * @param expired_at
 * @return void
 */
@Setter
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
	 * <h2> password</h2>
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
	 */
	public ResetForm() {
		super();
	}

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

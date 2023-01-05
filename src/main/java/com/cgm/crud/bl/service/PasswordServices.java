package com.cgm.crud.bl.service;

import com.cgm.crud.web.form.ResetForm;

public interface PasswordServices {

	ResetForm createResetToken(String email);

	void updatePassword(ResetForm resetForm);

	ResetForm getDataByToken(String token);
	
	void deleteToken(String email);

}

package com.sample.spring.form.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PasswordValidator implements ConstraintValidator<Password, String> {

	@Override
	public void initialize(Password password) {
		
	}

	@Override
	public boolean isValid(String password, ConstraintValidatorContext context) {
		if (password == null || password.length() == 0) {
			return false;
		}

		// Disable default error message when user keyin invalid format
		context.disableDefaultConstraintViolation();

		// Password should contain at least one Upper case letter
		if (!password.matches("^(?=.*[A-Z])(?=.*[a-z])(?=.*[!,@,#,$,%,^,&,*,(,)]).+$")) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate("{invalid.password.format}").addConstraintViolation();
			return false;
		} else {
			return true;
		}
	}

}
package com.sample.spring.form.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneValidator implements ConstraintValidator<Phone, String> {

	@Override
	public void initialize(Phone phone) {
	}

	@Override
	public boolean isValid(String phoneNum, ConstraintValidatorContext context) {
		if (phoneNum == null || phoneNum.length() == 0) {
			return false;
		}
		// Disable default validation if the Phone number is not blank
		context.disableDefaultConstraintViolation();
		
		// validate phone numbers of format "1234567890"
		if (phoneNum.matches("\\d{10}")) {
			return true;
		}
		
		else if (phoneNum.matches("\\d{3}[-\\.\\s]\\d{3}[-\\.\\s]\\d{4}")) {
			// validating phone number with -, . or spaces
			return true;
		} else if (phoneNum.matches("\\d{3}-\\d{3}-\\d{4}\\s(x|(ext))\\d{3,5}")) {
			// validating phone number with extension length from 3 to 5
			return true;
		} else if (phoneNum.matches("\\(\\d{3}\\)-\\d{3}-\\d{4}")) {
			// validating phone number where area code is in braces ()
			return true;
		} else {
			// return false if nothing matches the input
			context.buildConstraintViolationWithTemplate("{invalid.phone.format}").addConstraintViolation();
			return false;
		}
	}

}

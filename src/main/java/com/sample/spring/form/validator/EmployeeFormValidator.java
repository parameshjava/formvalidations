package com.sample.spring.form.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.sample.spring.form.model.EmployeeVO;

public class EmployeeFormValidator implements Validator {

	//which objects can be validated by this validator
	@Override
	public boolean supports(Class<?> paramClass) {
		return EmployeeVO.class.equals(paramClass);
	}

	@Override
	public void validate(Object obj, Errors errors) {
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "id.required");
		
		EmployeeVO emp = (EmployeeVO) obj;
		if(emp.getId() <=0){
			errors.rejectValue("id", "negativeValue", new Object[]{"'id'"}, "id can't be negative");
		}
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "role", "role.required");
	}
}

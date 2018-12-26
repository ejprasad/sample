package com.example.org.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.example.org.bindings.FormDetailsBasicBackingBean;


public class FormDetailsBasicValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return FormDetailsBasicBackingBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object obj, Errors errors) {

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "field.required");
    	System.out.println("Validator checked ok." + errors.getFieldErrors());

	}

}

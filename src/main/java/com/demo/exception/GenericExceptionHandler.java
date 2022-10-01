package com.demo.exception;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//@ControllerAdvice
public class GenericExceptionHandler {
	
	//@ExceptionHandler(Exception.class)
	//@ResponseStatus(HttpStatus.BAD_REQUEST)
	//@ResponseBody
	public ValidationErrorDTO validate(Exception ex) {
		//BindingResult result=ex.getMessage();
		List<FieldError> fieldErrors=new ArrayList<>();
		return processFieldErrors(fieldErrors);
		
	}

	private ValidationErrorDTO processFieldErrors(List<FieldError> fieldErrors) {
		ValidationErrorDTO dto=new ValidationErrorDTO();
		for(FieldError fieldError: fieldErrors) {
			
		}
		return null;
	}

}

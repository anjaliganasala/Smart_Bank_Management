package com.bank.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
		
	
	@ExceptionHandler(NoAccountFoundException.class)
	public String NoAccountFoundException(NoAccountFoundException ex) {
		return ex.getMessage();
	}
}

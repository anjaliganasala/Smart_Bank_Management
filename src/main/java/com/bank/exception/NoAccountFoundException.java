package com.bank.exception;

import com.bank.model.Customer;

public class NoAccountFoundException extends RuntimeException {
	
	public NoAccountFoundException(String msg) {
		super(msg);
	}

}

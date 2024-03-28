package com.nagarro.training.customerservice.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
	
	public CustomerAlreadyExistsException(String message) {
		super(message);
	}
}

package com.nagarro.training.accountservice.exception;

public class InsufficientBalanceException extends RuntimeException {
	
	public InsufficientBalanceException(String message) {
		super(message);
	}

}

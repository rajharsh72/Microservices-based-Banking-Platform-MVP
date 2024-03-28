package com.nagarro.training.accountservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nagarro.training.accountservice.model.ErrorResponse;

/**
 * @author harshraj01
 * Exception Handler class to handle all the exceptions with proper error code , 
 * message, and timestamp occured.
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	
	//Handler method to handle Exception when no account is found in the database for a given accountId
	@ExceptionHandler(NoAccountFoundException.class)
	public ResponseEntity<ErrorResponse> handlerNoAccountFoundException(NoAccountFoundException ex){
		//creates a error response to display proper response.
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	
	
	//Handler method to handle Exception when there is an insufficient balance in the account
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<ErrorResponse> handlerInsufficientBalanceException(InsufficientBalanceException ex){
		//creates a error response to display proper response.
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	//Handler method to handle when the customer is not valid
	@ExceptionHandler(InvalidCustomerException.class)
	public ResponseEntity<ErrorResponse> handlerInvalidCustomerException(InvalidCustomerException ex){
		//creates a error response to display proper response.
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}
	
	
	//Handler method to handle any other Exceptions
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handlerException(Exception ex){
		//creates a error response to display proper response.
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.BAD_REQUEST.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

}

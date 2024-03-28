package com.nagarro.training.customerservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nagarro.training.customerservice.model.ErrorResponse;

/**
 * @author harshraj01
 * A Global Exception handler method that handles all the exceptions
 *
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
	
	/**
	 * Exception Handler method to handle the CustomerNotFoundException
	 * when no requsted customer is present in the database
	 * 
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(CustomerNotFoundException.class)
	public ResponseEntity<ErrorResponse> handlerUserNotFoundException(CustomerNotFoundException ex){
		//create a new errorResponse object with proper status code, message and timestamp
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
	}
	
	
	/**
	 * Exception handler method to handle the CustomerAlreadyExistsException when
	 * we are trying to add a new customer but that customer is already present 
	 * in the database.
	 * @param ex
	 * @return
	 */
	@ExceptionHandler(CustomerAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handlerCustomerAlreadyExistsException(CustomerAlreadyExistsException ex){
		
		//create a new errorResponse object with proper status code, message and timestamp
		ErrorResponse errorResponse = new ErrorResponse(HttpStatus.NOT_FOUND.value(), ex.getMessage());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
	}

}

package com.nagarro.training.accountservice.service;

import com.nagarro.training.accountservice.model.Customer;

public interface ValidateCustomerService {
	
	Customer getCustomerDetail(Long customerId) throws Exception;
	
	 boolean validateCustomer(Long customerId) throws Exception;

}

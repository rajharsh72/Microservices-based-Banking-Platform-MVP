package com.nagarro.training.accountservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.accountservice.model.Customer;
import com.nagarro.training.accountservice.service.CustomerFeignClientService;
import com.nagarro.training.accountservice.service.ValidateCustomerService;

/**
 * @author harshraj01
 * 
 * Service class that validates the details from the customer 
 * that is being fetched from the Customer-Service microservice
 * by Feign Client.
 *
 */
@Service
public class ValidateCustomerServiceImpl implements ValidateCustomerService {
	

	@Autowired
	private CustomerFeignClientService feignClientServcice;
	
	
	/**
	 * Method to fetch the customer detail from Customer-Service microservice.
	 */
	@Override
	public Customer getCustomerDetail(Long customerId) throws Exception {
		try {

			Customer customer = this.feignClientServcice.getCustomer(customerId);
			return customer;
		}catch(Exception ex) {
			throw new Exception(ex.getMessage());
		}
		
	}
	
	/**
	 * Mehtod to validate the customer fetched from the other microservice 
	 */
	@Override
	public boolean validateCustomer(Long customerId) throws Exception {
		if(this.getCustomerDetail(customerId) != null) {
			return true;
		}
		return false;
	}
	
	
	
}

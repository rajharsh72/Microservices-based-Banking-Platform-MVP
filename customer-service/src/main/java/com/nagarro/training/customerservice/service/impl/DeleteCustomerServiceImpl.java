package com.nagarro.training.customerservice.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.customerservice.dao.CustomerDao;
import com.nagarro.training.customerservice.exception.CustomerNotFoundException;
import com.nagarro.training.customerservice.model.Customer;
import com.nagarro.training.customerservice.service.AccountFeignClientService;
import com.nagarro.training.customerservice.service.DeleteCustomerService;

import jakarta.transaction.Transactional;

/**
 * @author harshraj01
 * 
 * Service class that have handler methods curated to delete the customer details
 * from the database table
 *
 */
@Service
public class DeleteCustomerServiceImpl implements DeleteCustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Autowired
	private AccountFeignClientService feignClientService;
	
	private Logger logger = LoggerFactory.getLogger(DeleteCustomerService.class);
	
	
	
	/**
	 * Handler method to delete a particular customer from the database
	 */
	@Override
	@Transactional
	public Boolean deleteCustomer(Long id) {
		
		//checks if the customer is in the database or not
		Customer customer = this.customerDao.findById(id).orElseThrow(()->
								new CustomerNotFoundException("Customer not found in the database"));
		
		//it will delete all the accounts related to that customer
		boolean result = this.deleteAllAccounts(id);
		if(result) {
			this.customerDao.delete(customer);
			return true;
		}
		return false;
	}
	
	/**
	 * Method to delete all the accounts of a particular user from the database 
	 * of Account-Service
	 * @param customerId
	 * @return
	 */
	private boolean deleteAllAccounts(Long customerId) {
		try {
			
			//calling the api of Customer-Service to delete all the accounts associated to the customerId provided
			this.feignClientService.deleteAllAccounts(customerId);
			return true;
			
		}catch(Exception e) {
			logger.info("Error deleting all accounts of a customer", e.getMessage());
			return false;
		}
		 
		
	}
}

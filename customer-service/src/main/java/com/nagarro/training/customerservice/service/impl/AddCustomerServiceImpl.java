package com.nagarro.training.customerservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.customerservice.dao.CustomerDao;
import com.nagarro.training.customerservice.exception.CustomerAlreadyExistsException;
import com.nagarro.training.customerservice.model.Customer;
import com.nagarro.training.customerservice.service.AddCustomerService;

/**
 * @author harshraj01
 * Service class that will have handler method to add a new customer in the database
 *
 */
@Service
public class AddCustomerServiceImpl implements AddCustomerService {
	
	@Autowired 
	private CustomerDao customerDao;
	
	@Override
	public Customer addCustomer(Customer customer) {
		String email = customer.getEmail();
		//checks if the customer has already registered in the database with the same emailId
		Customer oldCustomer = this.customerDao.findByEmail(email);
		if(oldCustomer !=null) {
			throw new CustomerAlreadyExistsException("Customer already exists in the database with the same email address");
		}
		
		//saves the customer in the database
		return this.customerDao.save(customer);
	}
}

package com.nagarro.training.customerservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.customerservice.dao.CustomerDao;
import com.nagarro.training.customerservice.model.Customer;
import com.nagarro.training.customerservice.service.UpdateCustomerService;

import jakarta.transaction.Transactional;

/**
 * @author harshraj01
 * 
 * Service class that have the handler method to update the pre-existing customer
 * in our database
 *
 */
@Service
public class UpdateCustomerServiceImpl implements UpdateCustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public Customer updateCustomer(Customer customer) {
		return this.customerDao.save(customer);
	}
	

}

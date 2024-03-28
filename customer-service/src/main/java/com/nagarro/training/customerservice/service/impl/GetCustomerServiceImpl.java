package com.nagarro.training.customerservice.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.customerservice.dao.CustomerDao;
import com.nagarro.training.customerservice.exception.CustomerNotFoundException;
import com.nagarro.training.customerservice.model.Customer;
import com.nagarro.training.customerservice.service.GetCustomerService;

/**
 * @author harshraj01
 * Service class that contains handler methods to fetch Customer data from the
 * database
 *
 */
@Service
public class GetCustomerServiceImpl implements GetCustomerService {
	
	@Autowired
	private CustomerDao customerDao;
	
	/**
	 * Handler method to get all the Customers present in the database
	 */
	@Override
	public List<Customer> getAllCustomers(){
		
		//checks if no customer is present in the database
		if(this.customerDao.count() == 0) {
			throw new CustomerNotFoundException("No customers found in the database");
		}
		return this.customerDao.findAll();
	}
	
	/**
	 * Handler method to fetch a particular Customer from the database
	 * provided it's id
	 */
	@Override
	public Customer getCustomer(Long id){
		
		//find the customer in the database by the id of the customer
		Customer customer = this.customerDao.findById(id).orElseThrow(()->
										new CustomerNotFoundException("Customer not found in the database"));
		return customer;
	}
	

}

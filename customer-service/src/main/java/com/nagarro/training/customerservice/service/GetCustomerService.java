package com.nagarro.training.customerservice.service;

import java.util.List;

import com.nagarro.training.customerservice.model.Customer;

public interface GetCustomerService {

	List<Customer> getAllCustomers();

	Customer getCustomer(Long id);

}

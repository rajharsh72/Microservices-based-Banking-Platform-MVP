package com.nagarro.training.accountservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.accountservice.dao.AccountDao;
import com.nagarro.training.accountservice.exception.NoAccountFoundException;
import com.nagarro.training.accountservice.model.Account;
import com.nagarro.training.accountservice.model.ApiResponse;
import com.nagarro.training.accountservice.model.Customer;
import com.nagarro.training.accountservice.service.AccountDetailsService;
import com.nagarro.training.accountservice.service.ValidateCustomerService;

/**
 * @author harshraj01
 * 
 * Service class that fetches the account and customer details from the database
 * and then returns as ApiResponse.
 *
 */
@Service
public class AccountDetailsServiceImpl implements AccountDetailsService {
	
	@Autowired
	private ValidateCustomerService validateCustomerService;
	
	@Autowired
	private AccountDao accountDao;
	
	
	@Override
	public ApiResponse getAccountDetails(Long accountId) throws Exception {
		
		//fetch the account details from the database
		Account account = this.accountDao.findById(accountId).orElseThrow(()->
									new NoAccountFoundException("Account not registered with the provided account number"));
		
		//fetch the customer details related to the account from the customer microservice using FeignClient
		Customer customer = this.validateCustomerService.getCustomerDetail(account.getCustomerId());
		ApiResponse apiResponse = new ApiResponse(customer, account);
		return apiResponse;
	}
	
}

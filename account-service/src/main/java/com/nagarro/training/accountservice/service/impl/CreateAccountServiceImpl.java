package com.nagarro.training.accountservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.accountservice.dao.AccountDao;
import com.nagarro.training.accountservice.exception.InvalidCustomerException;
import com.nagarro.training.accountservice.model.Account;
import com.nagarro.training.accountservice.service.CreateAccountService;
import com.nagarro.training.accountservice.service.ValidateCustomerService;

/**
 * @author harshraj01
 * Service class to create a new account in the database to a related customer
 * 
 *
 */
@Service
public class CreateAccountServiceImpl implements CreateAccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private ValidateCustomerService validateCustomerService;
	
	/**
	 * Method that creates an account in the database and also validates if
	 * the customer id entered by the user is valid or not 
	 */
	@Override
	public Account createAccount(Account account) throws Exception {
		
		//logic to validate customer 
		boolean isValidCustomer = this.validateCustomerService.validateCustomer(account.getCustomerId());
		if(!isValidCustomer) {
			throw new InvalidCustomerException("Not a valid customer");
		}
		
		//save the account in the database
		Account newAccount = this.accountDao.save(account);
		return newAccount;
	}
}

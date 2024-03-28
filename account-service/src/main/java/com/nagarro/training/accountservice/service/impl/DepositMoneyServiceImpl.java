package com.nagarro.training.accountservice.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.accountservice.dao.AccountDao;
import com.nagarro.training.accountservice.exception.InvalidCustomerException;
import com.nagarro.training.accountservice.exception.NoAccountFoundException;
import com.nagarro.training.accountservice.model.Account;
import com.nagarro.training.accountservice.service.DepositMoneyService;
import com.nagarro.training.accountservice.service.ValidateCustomerService;

import jakarta.transaction.Transactional;

/**
 * @author harshraj01
 * Service class that will handle the deposit transaction in an account
 * only if the account is validated else throw an exception
 *
 */
@Service
public class DepositMoneyServiceImpl implements DepositMoneyService {
	
	@Autowired 
	private AccountDao accountDao;
	
	@Autowired
	private ValidateCustomerService validateCustomerService;
	
	/**
	 * Method that will deposit the money in the customer's account only if
	 * customer and account details are correct, otherwise throw an exception
	 */
	@Override
	@Transactional
	public Account depositMoney(Long accountId, BigDecimal amount) throws Exception {
		
		
		//get the account details if present else throw an exception
		Account account = this.accountDao.findById(accountId).orElseThrow(()->
												new NoAccountFoundException("Account not registered with the provided account number"));
		
		//logic to check if the customer details provided are valid or not
		Long customerId = account.getCustomerId();
		boolean isValidCustomer = this.validateCustomerService.validateCustomer(customerId);
		if(!isValidCustomer) {
			throw new InvalidCustomerException("Not a valid customer");
		}
				
		//getting the total balance from the account
		BigDecimal totalBalance = account.getTotalBalance();
		
		//updating opening balance (previous totalBalance will be current opeing balance)
		account.setOpeningBalance(totalBalance);
		
		//adding the deposited ammount in the totalBalance
		totalBalance = totalBalance.add(amount);
		
		//updating the closeBalance amount as totalBalance
		account.setClosingBalance(totalBalance);
		
		//updating totalBalance
		account.setTotalBalance(totalBalance);
		
		//saving the updated details in the database
		return this.accountDao.save(account);
	}

}

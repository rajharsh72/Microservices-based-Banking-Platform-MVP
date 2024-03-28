package com.nagarro.training.accountservice.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.accountservice.dao.AccountDao;
import com.nagarro.training.accountservice.exception.InsufficientBalanceException;
import com.nagarro.training.accountservice.exception.InvalidCustomerException;
import com.nagarro.training.accountservice.exception.NoAccountFoundException;
import com.nagarro.training.accountservice.model.Account;
import com.nagarro.training.accountservice.service.ValidateCustomerService;
import com.nagarro.training.accountservice.service.WithdrawMoneyService;

import jakarta.transaction.Transactional;

/**
 * @author harshraj01
 * Service class that will perform withdraw money transaction from the database only iff,
 * when the customer and account details provided are valid or not
 *
 */
@Service
public class WithdrawMoneyServiceImpl implements WithdrawMoneyService {
	
	@Autowired
	private AccountDao accountDao;
	
	@Autowired
	private ValidateCustomerService validateCustomerService;
	
	/**
	 * Method that will verify the customer and account detail and then
	 * withdraw the momeny of sufficient balance is there,
	 * else give and exception
	 */
	@Override
	@Transactional
	public Account withdrawMoney(Long accountId, BigDecimal amount) throws Exception {
		
		//fetching account from the database
		Account account = this.accountDao.findById(accountId).orElseThrow(()->
											new NoAccountFoundException("Account not registered with the provided account number"));

		Long customerId = account.getCustomerId();
		//fetching customer from the other microservice and validating
		boolean isValidCustomer = this.validateCustomerService.validateCustomer(customerId);
		if(!isValidCustomer) {
			throw new InvalidCustomerException("Not a valid customer");
		}
		
		//checks if there is sufficient money to withdraw from the account
		BigDecimal totalBalance = account.getTotalBalance();
		if(totalBalance.compareTo(amount) < 0 ) {
			throw new InsufficientBalanceException("Insufficient balance to perform transaction!!");
		}
		
		//setting opening balance (previous totalBalance will be current opening balance)
		account.setOpeningBalance(totalBalance);
		
		//subtracting the requested amount from the total balane
		totalBalance = totalBalance.subtract(amount);
		
		//setting closing balance as the total balance
		account.setClosingBalance(totalBalance);
		
		//updating the total balance
		account.setTotalBalance(totalBalance);
		
		//saving the updated parameters in the database
		return this.accountDao.save(account);
	}
	
}

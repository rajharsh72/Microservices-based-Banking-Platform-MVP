package com.nagarro.training.accountservice.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nagarro.training.accountservice.dao.AccountDao;
import com.nagarro.training.accountservice.exception.NoAccountFoundException;
import com.nagarro.training.accountservice.model.Account;
import com.nagarro.training.accountservice.service.DeleteAccountService;

import jakarta.transaction.Transactional;

/**
 * @author harshraj01
 * 
 * Service class to handle deletion of account(s) from the database
 *
 */
@Service
public class DeleteAccountServiceImpl implements DeleteAccountService {
	
	@Autowired
	private AccountDao accountDao;
	
	/**
	 * Method to delete an acount from the database if the account exists,
	 * else throw and exception
	 */
	@Override
	@Transactional
	public boolean deleteAccount(Long accountId) {
		Account account = this.accountDao.findById(accountId).orElseThrow(()->
									new NoAccountFoundException("Account not registered with the provided account number"));
		
		this.accountDao.delete(account);
		return true;

	}
	
	/**
	 * Method to delete all the related accounts of a particular customer
	 */
	@Override
	@Transactional
	public void deleteAccountsByCustomer(Long customerId) {
		this.accountDao.deleteByCustomerId(customerId);
	}
	
}

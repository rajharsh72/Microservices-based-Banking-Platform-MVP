package com.nagarro.training.accountservice.service;

public interface DeleteAccountService {

	boolean deleteAccount(Long accountId);

	void deleteAccountsByCustomer(Long customerId);

}

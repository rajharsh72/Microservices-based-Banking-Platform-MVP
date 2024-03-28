package com.nagarro.training.accountservice.model;

/**
 * @author harshraj01
 * POJO class that generates response as details of both customer and account.
 */
public class ApiResponse {
	
	private Customer customer;
	private Account account;
	
	public ApiResponse() {
		
	}
	
	
	/**
	 * @param customer
	 * @param account
	 */
	public ApiResponse(Customer customer, Account account) {
		this.customer = customer;
		this.account = account;
	}


	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}


	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}


	/**
	 * @return the account
	 */
	public Account getAccount() {
		return account;
	}


	/**
	 * @param account the account to set
	 */
	public void setAccount(Account account) {
		this.account = account;
	}


	@Override
	public String toString() {
		return "ApiResponse [customer=" + customer + ", account=" + account + "]";
	}
	
	
	
	

}

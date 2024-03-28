package com.nagarro.training.accountservice.controller;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.training.accountservice.model.Account;
import com.nagarro.training.accountservice.model.ApiResponse;
import com.nagarro.training.accountservice.service.AccountDetailsService;
import com.nagarro.training.accountservice.service.CreateAccountService;
import com.nagarro.training.accountservice.service.DeleteAccountService;
import com.nagarro.training.accountservice.service.DepositMoneyService;
import com.nagarro.training.accountservice.service.WithdrawMoneyService;

/**
 * @author harshraj01
 * 
 * REST Controller that contains different handler methods to handle/execute
 * operations specified to each URI
 *
 */
@RestController
@RequestMapping("/api/account")
public class AccountController {
	
	@Autowired
	private WithdrawMoneyService withdrawMoneyService;
	
	@Autowired
	private DepositMoneyService depositMoneyService;
	
	@Autowired
	private AccountDetailsService accountDetailsService;
	
	@Autowired
	private CreateAccountService createAccountService;
	
	@Autowired
	private DeleteAccountService deleteAccountService;
	
	
	
	/**
	 * Handler method that creates an account in the database
	 * @param account
	 * @return
	 * @throws Exception 
	 */
	@PostMapping("/add")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) throws Exception{
		Account newAccount = this.createAccountService.createAccount(account);
		
		return ResponseEntity.ok().body(newAccount);
	}
	
	
	/**
	 * Handler method to deposit money in the account of a particular customer
	 * @param customerId
	 * @param accountId
	 * @param amount
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/deposit")
	public ResponseEntity<Account> depositMoney(@RequestParam Long accountId,
												@RequestParam BigDecimal amount) throws Exception{
		
		Account account = this.depositMoneyService.depositMoney(accountId, amount);
		
		return ResponseEntity.ok().body(account);
		
	}
	
	
	/**
	 * Handler method to withdraw money from the account of a specific customer
	 * @param customerId
	 * @param accountId
	 * @param amount
	 * @return
	 * @throws Exception
	 */
	@PutMapping("/withdraw")
	public ResponseEntity<Account> withdrawMoney(@RequestParam Long accountId,
												@RequestParam BigDecimal amount) throws Exception{
		
		Account account = this.withdrawMoneyService.withdrawMoney(accountId, amount);
		return ResponseEntity.ok().body(account);
	}
	
	
	/**
	 * Handler method that gives the customer and account details related to accountId
	 * @param accountId
	 * @return
	 * @throws Exception
	 */
	@GetMapping("/get")
	public ResponseEntity<ApiResponse> getAccountDetails(@RequestParam Long accountId) throws Exception{
		
		ApiResponse apiResponse = this.accountDetailsService.getAccountDetails(accountId);
		return ResponseEntity.ok(apiResponse);
		
	}
	
	
	/**
	 * Handler method to delete a particular account from the database
	 * @param accountId
	 * @return
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteAccount(@RequestParam Long accountId){
		this.deleteAccountService.deleteAccount(accountId);
		return ResponseEntity.ok().body("Account deleted successfully!!");
	}
	
	
	/**
	 * Handler method that delete all the account records for a particular customer
	 * @param customerId
	 * @return
	 */
	@DeleteMapping("/delete/customer")
	public ResponseEntity<String> deleteAccountsByCustomerId(@RequestParam Long customerId){
		this.deleteAccountService.deleteAccountsByCustomer(customerId);
		return ResponseEntity.ok().body("Deleted....");
	}

}

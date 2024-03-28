package com.nagarro.training.customerservice.controller;

import java.util.List;

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

import com.nagarro.training.customerservice.model.Customer;
import com.nagarro.training.customerservice.service.AddCustomerService;
import com.nagarro.training.customerservice.service.DeleteCustomerService;
import com.nagarro.training.customerservice.service.GetCustomerService;
import com.nagarro.training.customerservice.service.UpdateCustomerService;

/**
 * @author harshraj01
 * REST Controller class that handles all the different operations to perform
 * when user hits different APIs.
 *
 */
@RestController
@RequestMapping("/api/customer")
public class CustomerController {
	
	@Autowired
	private GetCustomerService getCustomerService;
	
	@Autowired
	private AddCustomerService addCustomerService;
	
	@Autowired
	private UpdateCustomerService updateCustomerService;
	
	@Autowired
	private DeleteCustomerService deleteCustomerService;
	
	
	
	/**
	 * Handler method to fetch a particlar customer from the database 
	 * when GET API request is made
	 * @param id 
	 * @return
	 */
	@GetMapping("/get")
	public ResponseEntity<Customer> getCustomer(@RequestParam Long id){
		
		Customer customer = this.getCustomerService.getCustomer(id);
		return ResponseEntity.ok().body(customer);
	}
	
	/**
	 * Handler method to fetch all the customer data from the database when GET
	 * API request is made
	 * @return
	 */
	@GetMapping("/get-all")
	public ResponseEntity<List<Customer>> getAllCustomers(){
		
		List<Customer> customers = this.getCustomerService.getAllCustomers();
		return ResponseEntity.ok().body(customers);
	}
	
	
	/**
	 * Handler method to add a new customer in the database when POST API reuqest
	 * is made.
	 * @param customer
	 * @return
	 */
	@PostMapping("/add")
	public ResponseEntity<Customer> addCustomer(@RequestBody Customer customer){
		Customer newCustomer = this.addCustomerService.addCustomer(customer);
		return ResponseEntity.ok().body(newCustomer);
	}
	
	
	/**
	 * Handler method to delete a particular customer by it's ID when 
	 * DELETE API request method is made.
	 * @param id
	 * @return
	 */
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer(@RequestParam Long id){
		Boolean result = this.deleteCustomerService.deleteCustomer(id);
		if(!result) {
			return ResponseEntity.ok().body("Error occured while deleting customer");
		}
		return ResponseEntity.ok().body("Customer deleted successfully");
	}
	
	
	/**
	 * Handler method to update/modify any parameter of customer entity and save
	 * in the database when PUT API request is made.
	 * @param customer
	 * @return
	 */
	@PutMapping("/update")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
		Customer updatedCustomer = this.updateCustomerService.updateCustomer(customer);
		return ResponseEntity.ok().body(updatedCustomer);
	}
		
}

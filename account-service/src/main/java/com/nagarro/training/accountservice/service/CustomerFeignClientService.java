package com.nagarro.training.accountservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.training.accountservice.model.Customer;

/**
 * @author harshraj01
 * Service interface that is FeignClient that will make a API request
 * to our Customer-Service instance to establish an inter-service communication
 *
 */
@FeignClient(name="Customer-Service")
public interface CustomerFeignClientService {

	@GetMapping("/api/customer/get")
	public Customer getCustomer(@RequestParam(name="id") Long customerId);
}

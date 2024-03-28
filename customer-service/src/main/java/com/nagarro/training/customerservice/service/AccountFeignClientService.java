package com.nagarro.training.customerservice.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author harshraj01
 * 
 * Service interface to define configs for FeignClient that will make 
 * API requests to Account-Service and establish an interservice communication
 * between our different microservices.
 *
 */
@FeignClient(name="Account-Service")
public interface AccountFeignClientService {
	
	@DeleteMapping("/api/account/delete/customer")
	void deleteAllAccounts(@RequestParam(name="customerId") Long customerId);
}

package com.nagarro.training.accountservice.service;

import com.nagarro.training.accountservice.model.ApiResponse;

public interface AccountDetailsService {

	ApiResponse getAccountDetails(Long accountId) throws Exception;

}

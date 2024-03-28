package com.nagarro.training.accountservice.service;

import java.math.BigDecimal;

import com.nagarro.training.accountservice.model.Account;

public interface WithdrawMoneyService {

	Account withdrawMoney(Long accountId, BigDecimal amount) throws Exception;

}

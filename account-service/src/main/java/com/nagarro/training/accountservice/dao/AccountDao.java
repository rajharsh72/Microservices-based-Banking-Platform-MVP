package com.nagarro.training.accountservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.training.accountservice.model.Account;

/**
 * @author harshraj01
 * 
 * Repository class to perform different CRUD operations related to Account entity 
 * in database
 *
 */

@Repository
public interface AccountDao extends JpaRepository<Account, Long> {

	void deleteByCustomerId(Long customerId);

}

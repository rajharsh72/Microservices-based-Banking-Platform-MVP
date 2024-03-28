package com.nagarro.training.customerservice.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.training.customerservice.model.Customer;

@Repository
public interface CustomerDao extends JpaRepository<Customer, Long> {

	Customer findByEmail(String email);


}

package com.nagarro.training.customerservice.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.training.customerservice.model.Address;

@Repository
public interface AddressDao extends JpaRepository<Address, Long> {

}

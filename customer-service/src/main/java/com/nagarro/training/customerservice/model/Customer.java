package com.nagarro.training.customerservice.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;


/**
 * @author harshraj01
 * 
 * POJO class to define our Customer entity with different attributes 
 */
@Entity
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private long phoneNo;
	private String gender;
	private String email;
	
	@OneToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name="address_id", referencedColumnName = "id")
	private Address address;
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}


	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}


	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}


	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * @return the phoneNo
	 */
	public long getPhoneNo() {
		return phoneNo;
	}


	/**
	 * @param phoneNo the phoneNo to set
	 */
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}


	/**
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}


	/**
	 * @param gender the gender to set
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}


	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}


	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}


	/**
	 * @return the address
	 */
	public Address getAddress() {
		return address;
	}


	/**
	 * @param address the address to set
	 */
	public void setAddress(Address address) {
		this.address = address;
	}
	
	
//
//	/**
//	 * @return the accountDetails
//	 */
//	public List<Account> getAccountDetails() {
//		return accountDetails;
//	}
//
//
//	/**
//	 * @param accountDetails the accountDetails to set
//	 */
//	public void setAccountDetails(List<Account> accountDetails) {
//		this.accountDetails = accountDetails;
//	}
	
	

	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", phoneNo=" + phoneNo + ", gender=" + gender + ", email="
				+ email + ", address=" + address + "]";
	}

	
	
	
}

package com.nagarro.training.accountservice.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author harshraj01
 * 
 * POJO class for Address details of customer
 *
 */
@Getter
@Setter
@NoArgsConstructor
@Data
public class Address {
	
	@JsonProperty("id")
	private Long id;
	
	@JsonProperty("street")
	private String street;
	
	@JsonProperty("city")
	private String city;
	
	@JsonProperty("state")
	private String state;
	
	@JsonProperty("zipCode")
	private int zipCode;
	
	@JsonProperty("country")
	private String country;
	
}

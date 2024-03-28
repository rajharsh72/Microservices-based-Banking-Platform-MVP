package com.nagarro.training.accountservice.model;

import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;

/**
 * @author harshraj01
 * 
 * POJO class for account entity to store different parameters of an account
 *
 */
@Entity
@Table(name="account")
public class Account {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator="account_id_generator")
	@SequenceGenerator(name="account_id_generator",
						sequenceName="account_id_sequence",
						allocationSize=1)
	@Column(name="account_no")
	private Long id;
	
	@Column(name="account_type")
	private String type;
	
	private String bankName;
	
	private BigDecimal closingBalance = new BigDecimal("0.00");
	
	private BigDecimal openingBalance = new BigDecimal("0.00");
	
	@Column(name="account_balance")
	private BigDecimal totalBalance = new BigDecimal("0.00");
	
	private Long customerId;
	
	public Account() {
		
	}

	/**
	 * @param id
	 * @param type
	 * @param closingBalance
	 * @param openingBalance
	 * @param totalBalance
	 * @param customerId
	 */
	public Account(Long id, String type, BigDecimal closingBalance, BigDecimal openingBalance, BigDecimal totalBalance,
			Long customerId, String bankName) {
		this.id = id;
		this.type = type;
		this.closingBalance = closingBalance;
		this.openingBalance = openingBalance;
		this.totalBalance = totalBalance;
		this.customerId = customerId;
		this.bankName = bankName;
	}

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
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the closingBalance
	 */
	public BigDecimal getClosingBalance() {
		return closingBalance;
	}

	/**
	 * @param closingBalance the closingBalance to set
	 */
	public void setClosingBalance(BigDecimal closingBalance) {
		this.closingBalance = closingBalance;
	}

	/**
	 * @return the openingBalance
	 */
	public BigDecimal getOpeningBalance() {
		return openingBalance;
	}

	/**
	 * @param openingBalance the openingBalance to set
	 */
	public void setOpeningBalance(BigDecimal openingBalance) {
		this.openingBalance = openingBalance;
	}

	/**
	 * @return the totalBalance
	 */
	public BigDecimal getTotalBalance() {
		return totalBalance;
	}

	/**
	 * @param totalBalance the totalBalance to set
	 */
	public void setTotalBalance(BigDecimal totalBalance) {
		this.totalBalance = totalBalance;
	}

	/**
	 * @return the customerId
	 */
	public Long getCustomerId() {
		return customerId;
	}

	/**
	 * @param customerId the customerId to set
	 */
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	
	
	

	/**
	 * @return the bankName
	 */
	public String getBankName() {
		return bankName;
	}

	/**
	 * @param bankName the bankName to set
	 */
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", type=" + type + ", bankName=" + bankName + ", closingBalance=" + closingBalance
				+ ", openingBalance=" + openingBalance + ", totalBalance=" + totalBalance + ", customerId=" + customerId
				+ "]";
	}
	
	
	
	
	
}

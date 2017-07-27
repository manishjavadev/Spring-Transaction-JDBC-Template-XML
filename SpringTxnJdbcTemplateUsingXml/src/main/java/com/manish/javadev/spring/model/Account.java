package com.manish.javadev.spring.model;

/**
 * Entity bean with JPA annotations Hibernate provides JPA implementation
 * 
 * @author Manish
 * 
 */

public class Account {

	private Long id;

	private String accountHolderName;

	private Double amount;

	public Account() {
		super();
	}

	public Account(Long accountId, String accountHolderName, Double amount) {
		super();
		this.id = accountId;
		this.accountHolderName = accountHolderName;
		this.amount = amount;

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAccountHolderName() {
		return accountHolderName;
	}

	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", accountHolderName=" + accountHolderName
				+ ", amount=" + amount + "]";
	}

}
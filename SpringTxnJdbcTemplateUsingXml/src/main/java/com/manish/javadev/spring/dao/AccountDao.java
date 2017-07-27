package com.manish.javadev.spring.dao;

import com.manish.javadev.spring.model.Account;

/**
 * @author Deepak
 * 
 */
public interface AccountDao {

	void withdrawAmount(Long accountFrom, Double amount);

	void depositAmount(Long accountTo, Double ammount);

	Account createAccount(Account account);

}

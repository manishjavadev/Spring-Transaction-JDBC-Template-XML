package com.manish.javadev.spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manish.javadev.spring.dao.AccountDao;
import com.manish.javadev.spring.model.Account;

@Service("accountService")
public class AccountServiceImpl implements AccountService {
	@Autowired
	private AccountDao accountDao;

	public void setPersonDAO(AccountDao accountDao) {
		this.accountDao = accountDao;
	}

	public void createAccount(Long accountNumber, Double amount) {
		Account account = new Account(new Long(accountNumber), "Manish",
				amount == null ? null : amount);
		account = accountDao.createAccount(account);
		System.out.println("Account = " + account);
	}

	public void fundTransfer(Long accountFrom, Long accountTo, Double amount) {
		accountDao.withdrawAmount(accountFrom, amount);
		accountDao.depositAmount(accountTo, amount);
	}

	public void depositAmount(Long accountTo, Double amount) {
		accountDao.depositAmount(accountTo, amount);
	}
}

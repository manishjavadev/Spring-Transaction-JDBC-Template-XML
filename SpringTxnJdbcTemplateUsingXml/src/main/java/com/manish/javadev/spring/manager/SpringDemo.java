package com.manish.javadev.spring.manager;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.manish.javadev.spring.service.AccountService;

/**
 * @author Manish
 * 
 */
public class SpringDemo {
	/*
	 * drop database javadev; create database javadev; create table
	 * Account(ACCOUNT_ID long,ACCOUNT_HOLDER_NAME varchar(35),AMOUNT double);
	 * use javadev;
	 */

	public static void main(String[] args) {

		// getting ApplcationContext reference
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		System.out.println("CTX = " + ctx);

		AccountService accountService = (AccountService) ctx
				.getBean("accountService");
		//accountService.createAccount(new Long(100), new Double(25000));
		//accountService.createAccount(new Long(200), new Double(30000));
		accountService.fundTransfer(new Long(100), new Long(200), new Double(
				1000));
		System.out.println("Done");
	}
}

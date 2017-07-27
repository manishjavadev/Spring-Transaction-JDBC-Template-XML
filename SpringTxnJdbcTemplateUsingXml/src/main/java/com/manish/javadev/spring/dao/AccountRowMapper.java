package com.manish.javadev.spring.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.manish.javadev.spring.model.Account;

public class AccountRowMapper implements RowMapper<Account> {

	public Account mapRow(ResultSet rs, int id) throws SQLException {
		Account account = new Account();
		account.setId(rs.getLong("ACCOUNT_ID"));
		account.setAccountHolderName(rs.getString("ACCOUNT_HOLDER_NAME"));
		account.setAmount(rs.getDouble("AMOUNT"));
		return account;
	}

}

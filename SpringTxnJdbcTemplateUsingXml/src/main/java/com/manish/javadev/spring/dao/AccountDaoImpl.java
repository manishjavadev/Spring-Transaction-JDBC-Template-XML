package com.manish.javadev.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.manish.javadev.spring.model.Account;

@Repository
public class AccountDaoImpl implements AccountDao {

	private static final Logger logger = LoggerFactory
			.getLogger(AccountDaoImpl.class);
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void withdrawAmount(Long accountFrom, Double amount) {
		String sql = "Select * from Account where ACCOUNT_ID=?";
		Account account = jdbcTemplate.queryForObject(sql,
				new AccountRowMapper(), accountFrom);

		String updateSQL = "update Account set AMOUNT=? where ACCOUNT_ID=?";
		int update = jdbcTemplate.update(updateSQL, account.getAmount()
				- amount, account.getId());
		if (update > 0) {
			System.out.println("Rs = " + amount + " transfer from number "
					+ account.getId());
		}
	}

	public void depositAmount(Long accountTo, Double amount) {
		String sql = "Select * from Account where ACCOUNT_ID=?";
		Account account = jdbcTemplate.queryForObject(sql,
				new AccountRowMapper(), accountTo);

		String updateSQL = "update Account set AMOUNT=? where ACCOUNT_ID=?";
		int update = jdbcTemplate.update(updateSQL, account.getAmount()
				+ amount, account.getId());
		if (update > 0) {
			System.out.println("Rs = " + amount + " transfer from number "
					+ account.getId());
		}
		//throw new RuntimeException();
	}

	public Account createAccount(final Account account) {
		PreparedStatementCreator psc = new PreparedStatementCreator() {

			public PreparedStatement createPreparedStatement(Connection con)
					throws SQLException {
				PreparedStatement ps = con
						.prepareStatement("insert into account values(?,?,?)");
				ps.setLong(1, account.getId());
				ps.setString(2, account.getAccountHolderName());
				ps.setDouble(3, account.getAmount());
				return ps;
			}
		};
		jdbcTemplate.update(psc);

		return account;
	}

}

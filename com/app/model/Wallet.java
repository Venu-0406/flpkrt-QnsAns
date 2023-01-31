package com.app.model;

import java.util.ArrayList;
import java.util.List;

public class Wallet {

	private String username;
	private Double balance;
	
	private List<Transaction> transaction;

	public Wallet() {
		super();
	}

	public Wallet(String username, Double balance) {
		super();
		this.username = username;
		this.balance = balance;
		this.transaction = new ArrayList<>();
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Double getBalance() {
		return balance;
	}

	public void setBalance(Double balance) {
		this.balance = balance;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	
	
}

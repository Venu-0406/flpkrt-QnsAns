package com.app.model;

public class Transaction {

	private String type;
	private String fromUser;
	private Double amount;
	
	public Transaction() {
		super();
	}
	
	public Transaction(String type, String fromUser, Double amount) {
		super();
		this.type = type;
		this.fromUser = fromUser;
		this.amount = amount;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}
	
}

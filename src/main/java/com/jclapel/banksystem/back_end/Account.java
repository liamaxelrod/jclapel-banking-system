package com.jclapel.banksystem.back_end;

import java.util.Stack;

import org.bson.codecs.pojo.annotations.BsonProperty;

public class Account {
	/*

	Account class for account creation of a customer. Contains a unique ID, a balance and transaction history, 
	also determining whether the account is a savings account.

	Main Contributor(s):
	Contributor(s):

	*/

	@BsonProperty(value = "account_id")
	private final int id;
	@BsonProperty(value = "customer_id")
	private int customerId;
	private double balance;
	@BsonProperty(value = "is_savings")
	private final boolean isSavings;
	private Stack<Transaction> transactions = new Stack<>();

	public Account(int id, int customerId, boolean isSavings) {
		// Constructor for account, creates an account from ID and a boolean of determining account type
		// TODO: Is there only two types of accounts?
		this.isSavings = isSavings;
		this.customerId = customerId;
		this.balance = 0;
		this.id = id;
	}
	
	public boolean addTransaction(Transaction transaction) {
		// Adds transaction to transaction stack(history)
		transactions.push(transaction);
		return true;
	}

	public double getBalance() {
		// Returns the balance of the account object
		return balance;
	}

	public int getId() {
		// Returns the ID of the account object
		return id;
	}
	public int getCustomerId() {
		// Returns the customer ID associated to the account
		return customerId;
	}

	public void setBalance(double balance) {
		// Sets the balance of the account object
		this.balance = balance;
	}

	public Stack<Transaction> getTransactions(){
		// Returns the transactions history
		return transactions;
	}

	public boolean isSavings() {
		// Returns true if the account is a savings account
		return isSavings;
	}
}

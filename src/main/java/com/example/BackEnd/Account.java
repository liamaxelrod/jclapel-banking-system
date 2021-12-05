package com.example.BackEnd;

import java.util.Stack;

public class Account {
    private final int ID;
    private double balance;
    private Stack<Transaction> transactions = new Stack<>();

    public Account(int ID){
        this.balance=0;
        this.ID=ID;
    }
    
    public boolean addTransaction(Transaction transaction){
        transactions.push(transaction);
        return true;
    }

    public double getBalance() {
        return balance;
    }

    public int getID() {
        return ID;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public Stack<Transaction> getTransactions(){
        return transactions;
    }

}

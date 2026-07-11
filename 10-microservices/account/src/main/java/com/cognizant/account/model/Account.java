package com.cognizant.account.model;

public class Account {
    private String number;
    private String type;
    private long balance;

    public Account(String number, String type, long balance) {
        this.number = number;
        this.type = type;
        this.balance = balance;
    }

    public String getNumber() { return number; }
    public String getType() { return type; }
    public long getBalance() { return balance; }
}

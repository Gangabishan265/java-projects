package com.example;

public class CurrentAccount extends Account {
    private double overdraftLimt;

    public CurrentAccount(String accountNumber, String accountHolder, double balance, double overdraftLimt) {
        super(accountNumber, accountHolder, balance);
        this.overdraftLimt = overdraftLimt;
    }

    public void withdraw(double amount) {
        if (amount <= balance + overdraftLimt) {
            balance -= amount;
            System.out.println("withdraw balance: " + balance);
        } else {
            System.out.println("balance not found");
        }
    }
}
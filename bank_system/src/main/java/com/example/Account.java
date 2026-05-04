package com.example;

public class Account {
    private String accountNumber;
    private String accountHolder;
    protected double balance;

    public Account(String accountNumber, String accountHolder, double balance) {
        this.accountNumber = accountNumber;
        this.accountHolder = accountHolder;
        this.balance = balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + accountHolder + "add new balance: " + balance);
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            System.out.println(amount + accountHolder + "withdraw balance: " + balance);
        } else {
            System.out.println("balance not found");
        }
    }

    public void chackBalance() {
        System.out.println("crrent balance: " + balance);
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

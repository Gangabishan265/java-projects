package com.example;

import java.util.ArrayList;

public class Bank {
    private static ArrayList<Account> accounts = new ArrayList<>();

    public void addAccount(Account Account) {
        accounts.add(Account);
        System.out.println("account added: " + Account.getAccountNumber());
    }

    public Account findAccount(Object accountNumber) {
        for (Account acc : accounts) {
            if (acc.getAccountNumber().equals(accountNumber)) {
                return acc;
            }
        }
        System.out.println("account is not found");
        return null;
    }

    public void transferFund(Object fromAccountNumber, Object toAccountNumber, double amount) {
        Account fromAccount = findAccount(fromAccountNumber);
        Account toAccount = findAccount(toAccountNumber);

        if (fromAccount != null && toAccount != null) {
            fromAccount.withdraw(amount);
            toAccount.deposit(amount);

            System.out.println("transferFund " + amount + " from " + fromAccountNumber + " to " + toAccountNumber);
        }
    }
}

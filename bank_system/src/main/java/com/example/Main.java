package com.example;

public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        SavingAccount saving = new SavingAccount("s001", " jone ", 2000, 50);
        CurrentAccount crunt = new CurrentAccount("s002", " maix ", 3000, 500);

        bank.addAccount(saving);
        bank.addAccount(crunt);

        saving.withdraw(500);
        crunt.deposit(600);

        saving.addintrast();
        bank.transferFund("s002", "s001", 200);

        saving.chackBalance();
        crunt.chackBalance();
    }
}
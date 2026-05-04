package com.example;

class SavingAccount extends Account {
    private double intrastRate;

    public SavingAccount(String accountNumber, String accountHolder, double balance, double intrastRate) {
        super(accountNumber, accountHolder, balance);
        this.intrastRate = intrastRate;
    }

    public void addintrast() {
        double intrast = balance * (intrastRate / 100);
        deposit(intrast);
        System.out.println("intrast added: " + intrast);
    }
}
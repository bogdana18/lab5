package org.example;

public class BankAccount {

    private int accountNumber;
    private String accountName;
    private double balance;

    public BankAccount(int accountNumber, String accountName, double balance) {
        this.accountNumber = accountNumber;
        this.accountName = accountName;
        this.balance = balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws InsufficientFundsException, NegativeAmountException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        if (amount < 0) {
            throw new NegativeAmountException("Amount cannot be negative");
        }
        balance -= amount;
    }

    public String getAccountSummary() {
        return "Account number: " + accountNumber + ", account name: " + accountName + ", balance: " + balance;
    }
}


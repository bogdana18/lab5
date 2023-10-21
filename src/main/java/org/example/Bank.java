package org.example;

import java.util.ArrayList;
import java.util.List;

public class Bank {

    private List<BankAccount> accounts;

    public Bank() {
        accounts = new ArrayList<>();
    }

    public void createAccount(String accountName, double initialDeposit) {
        BankAccount account = new BankAccount(accounts.size() + 1, accountName, initialDeposit);
        accounts.add(account);
    }

    public BankAccount findAccount(int accountNumber) throws AccountNotFoundException {
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                return account;
            }
        }
        throw new AccountNotFoundException("Account not found");
    }

    public void transferMoney(int fromAccountNumber, int toAccountNumber, double amount) throws InsufficientFundsException, AccountNotFoundException {
        BankAccount fromAccount = findAccount(fromAccountNumber);
        BankAccount toAccount = findAccount(toAccountNumber);
        fromAccount.withdraw(amount);
        toAccount.deposit(amount);
    }
}


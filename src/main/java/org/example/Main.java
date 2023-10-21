package org.example;
public class Main {
    public static void main(String[] args) throws InsufficientFundsException, AccountNotFoundException {
        Bank bank = new Bank();

        bank.createAccount("John Doe", 100.0);
        bank.createAccount("Jane Doe", 200.0);

        BankAccount johnDoeAccount = bank.findAccount(1);
        BankAccount janeDoeAccount = bank.findAccount(2);

        johnDoeAccount.withdraw(50.0);
        janeDoeAccount.deposit(50.0);

        System.out.println(johnDoeAccount.getAccountSummary());
        System.out.println(janeDoeAccount.getAccountSummary());

    }
}
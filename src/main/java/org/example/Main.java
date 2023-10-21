package org.example;
public class Main {
    public static void main(String[] args) throws InsufficientFundsException, AccountNotFoundException, NegativeAmountException {
        Bank bank = new Bank();

        bank.createAccount("John Doe", 100.0);
        bank.createAccount("Jane Doe", 200.0);

        BankAccount johnDoeAccount = bank.findAccount(1);
        BankAccount janeDoeAccount = bank.findAccount(2);

        try {
            johnDoeAccount.withdraw(-50.0);
        } catch (InsufficientFundsException | NegativeAmountException e) {
            System.out.println(e.getMessage());
        }

        System.out.println(johnDoeAccount.getAccountSummary());
        System.out.println(janeDoeAccount.getAccountSummary());

    }
}
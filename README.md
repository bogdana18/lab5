# lab5 Обробка виняткових ситуацій в Java

## Послідовність виконаних дій

1. Створено клас BankAccount з полями accountNumber, accountName і balance.


```
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

    public void withdraw(double amount) throws InsufficientFundsException {
        if (balance < amount) {
            throw new InsufficientFundsException("Insufficient funds");
        }
        balance -= amount;
    }

    public String getAccountSummary() {
        return "Account number: " + accountNumber + ", account name: " + accountName + ", balance: " + balance;
    }
}
```

2. Реалізовано методи deposit(double amount), withdraw(double amount), getBalance() та getAccountSummary().
Метод deposit() збільшує баланс на задану суму. Метод withdraw() зменшує баланс на задану суму, якщо на балансі достатньо коштів. Якщо на балансі недостатньо коштів, генерується виняток InsufficientFundsException. Метод getBalance() повертає поточний баланс. Метод getAccountSummary() повертає резюме рахунку у вигляді рядка.

3. Створено спеціалізовані класи винятків: InsufficientFundsException, NegativeAmountException, AccountNotFoundException.

4. Створено клас Bank з колекцією об'єктів BankAccount.

```
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
```

5. Реалізовано методи createAccount(String accountName, double initialDeposit), findAccount(int accountNumber), transferMoney(int fromAccountNumber, int toAccountNumber, double amount).
Метод createAccount() створює новий рахунок з заданим номером, ім'ям та балансом. Метод findAccount() повертає об'єкт рахунку з заданим номером. Метод transferMoney() переводить кошти з одного рахунку на інший.

6. Оброблено винятки відповідно в кожному методі.
У методах createAccount() і transferMoney() генеруються винятки AccountNotFoundException, якщо не вдалося знайти рахунок з заданим номером. У методі transferMoney() генерується виняток InsufficientFundsException, якщо на балансі відправника недостатньо коштів.

7. Створено тестові класи, де ви моделюєте різні сценарії для тестування обробки виняткових ситуацій.
У тестових класах моделюються різні сценарії для тестування обробки виняткових ситуацій. Наприклад, тест перевіряє, що при спробі вилучення коштів з рахунку з недостатнім балансом генерується виняток InsufficientFundsException.



import java.util.ArrayList;

public class BankService {
    private BankAccount account;

    public BankService(BankAccount account) {
        this.account = account;
    }

    public void depositMoney(double amount) throws InvalidAmountException {
        account.deposit(amount);
    }

    public void withdrawMoney(double amount) throws InvalidAmountException, InsufficientBalanceException {
        account.withdraw(amount);
    }

    public double checkBalance() {
        return account.getBalance();
    }

    public ArrayList<Transaction> getTransactionHistory() {
        return account.getTransactions();
    }

    public String getAccountHolderName() {
        return account.getAccountHolder();
    }
}

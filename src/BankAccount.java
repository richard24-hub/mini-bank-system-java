import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private double balance;
    private List<Transaction> transactions;

    public BankAccount() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public BankAccount(String name, int balance){
        this.name = name; 
        this.balance = balance; 
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void addBalance(double amount) {
        this.balance += amount;
    }

    public void reduceBalance(double amount) {
        this.balance -= amount;
    }

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }
    public void deposit(double amount) throws InvalidAmountException {
    if (amount <= 0) {
        throw new InvalidAmountException("Deposit amount must be greater than 0.");
    }

    addBalance(amount);
    addTransaction(new Transaction(TransactionType.DEPOSIT, amount, balance));
}

public void withdraw(double amount) throws InvalidAmountException, InsufficientBalanceException {
    if (amount <= 0) {
        throw new InvalidAmountException("Withdraw amount must be greater than 0.");
    }

    if (amount > balance) {
        throw new InsufficientBalanceException("Withdraw cannot exceed balance.");
    }

    reduceBalance(amount){
    addTransaction(new Transaction(TransactionType.WITHDRAW, amount, balance));
}

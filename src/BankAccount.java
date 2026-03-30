import java.util.ArrayList;
import java.util.List;

public class BankAccount {
    private String name;
    private double balance;
    private List<Transaction> transactions;

    // ✅ Constructor
    public BankAccount(String name, double balance) {
        this.name = name;
        this.balance = balance;
        this.transactions = new ArrayList<>();
    }

    // ✅ Getter name
    public String getAccountHolder() {
        return name;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }
}

import java.util.List;

public class BankService {
    private BankAccount account;

    public BankService(BankAccount account) {
        this.account = account;
    }

    public void depositMoney(double amount) {
        if (amount > 0) {
            account.deposit(amount);
        }
    }

    public void withdrawMoney(double amount) {
        if (amount > 0) {
            account.withdraw(amount);
        }
    }

    public double checkBalance() {
        return account.getBalance();
    }

    public List<Transaction> getTransactionHistory() {
        return account.getTransactions();
    }

    public String getAccountHolderName() {
        return account.getAccountHolder();
    }
}

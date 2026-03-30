import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class BankService {
    private final BankAccount account;

    public BankService(BankAccount account) {
        // Menggunakan Objects.requireNonNull untuk menghindari NullPointerException di awal
        this.account = Objects.requireNonNull(account, "Account cannot be null");
    }

    public void depositMoney(double amount) throws InvalidAmountException {
        if (amount <= 0) {
            throw new InvalidAmountException("Deposit amount must be positive");
        }
        account.deposit(amount);
    }

    public void withdrawMoney(double amount) throws InvalidAmountException, InsufficientBalanceException {
        if (amount <= 0) {
            throw new InvalidAmountException("Withdrawal amount must be positive");
        }
        account.withdraw(amount);
    }

    public double checkBalance() {
        return account.getBalance();
    }

    /**
     * Mengembalikan list yang tidak bisa dimodifikasi (Read-only) 
     * untuk menjaga integritas data riwayat transaksi.
     */
    public List<Transaction> getTransactionHistory() {
        return Collections.unmodifiableList(account.getTransactions());
    }

    public String getAccountHolderName() {
        return account.getAccountHolder();
    }

    @Override
    public String toString() {
        return String.format("BankService[Holder: %s, Balance: %.2f]", 
                             getAccountHolderName(), checkBalance());
    }
}

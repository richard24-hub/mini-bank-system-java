import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            BankAccount account = new BankAccount("Mini Bank User", 1000);
            BankService bankService = new BankService(account);

            int choice = 0;

            do {
                System.out.println("\\n===== MINI BANK SYSTEM =====");
                System.out.println("Account Holder: " + bankService.getAccountHolderName());
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. View Transaction History");
                System.out.println("5. Exit");
                System.out.print("Choose menu: ");

                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter deposit amount: ");
                        double depositAmount = scanner.nextDouble();
                        bankService.depositMoney(depositAmount);
                        System.out.println("Deposit successful.");
                        break;

                    case 2:
                        System.out.print("Enter withdraw amount: ");
                        double withdrawAmount = scanner.nextDouble();
                        bankService.withdrawMoney(withdrawAmount);
                        System.out.println("Withdraw successful.");
                        break;

                    case 3:
                        System.out.println("Current balance: " + bankService.checkBalance());
                        break;

                    case 4:
                        if (bankService.getTransactionHistory().isEmpty()) {
                            System.out.println("No transaction history available.");
                        } else {
                            System.out.println("\\n--- Transaction History ---");
                            for (int i = 0; i < bankService.getTransactionHistory().size(); i++) {
                                System.out.println((i + 1) + ". " + bankService.getTransactionHistory().get(i));
                            }
                        }
                        break;

                    case 5:
                        System.out.println("Exiting program. Thank you.");
                        break;

                    default:
                        throw new IllegalArgumentException("Menu choice must be between 1 and 5.");
                }

            } while (choice != 5);

        } catch (InputMismatchException e) {
            System.out.println("Error: Input must be a number.");
        } catch (InvalidAmountException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Unexpected error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}

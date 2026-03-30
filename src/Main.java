public class Main {
    public static void main(String[] args) {
        
        BankAccount myAccount = new BankAccount("Mini Bank User", 1000.0);
        
       
        BankService service = new BankService(myAccount);

        System.out.println("Nasabah: " + service.getAccountHolderName());
        
      
        service.depositMoney(500.0);
        service.withdrawMoney(200.0);

        System.out.println("Saldo saat ini: " + service.checkBalance());
        
        System.out.println("Riwayat Transaksi:");
        for (Transaction t : service.getTransactionHistory()) {
            System.out.println(t);
        }
    }
}

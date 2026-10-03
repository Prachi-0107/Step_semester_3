package classes_and_objects.class_problems;

/**
 * Live Session Walkthrough: Encapsulation & Controlled Data Access.
 * Demonstrates keeping state private and enforcing validation rules inside methods.
 */
public class MessWalletDemo {

    public static class Wallet {
        private double balance;

        public Wallet(double openingBalance) {
            if (openingBalance < 0) {
                System.out.println("Warning: Opening balance cannot be negative. Setting to 0.");
                this.balance = 0;
            } else {
                this.balance = openingBalance;
            }
        }

        public void topUp(double amount) {
            if (amount <= 0) {
                System.out.println("Top-up rejected: amount must be positive.");
                return;
            }
            balance += amount;
        }

        public void deduct(double amount) {
            if (amount > balance) {
                System.out.println("Deduct rejected: insufficient balance");
                return;
            }
            balance -= amount;
        }

        public double getBalance() {
            return balance;
        }
    }

    public static void main(String[] args) {
        Wallet wallet = new Wallet(500);
        wallet.topUp(200);
        System.out.println("Balance after top-up: " + wallet.getBalance());
        wallet.deduct(1000);
        System.out.println("Final balance: " + wallet.getBalance());
    }
}

package classes_and_objects.assigment_problems;

/**
 * Assignment Problem 2: Encapsulated Campus Digital Wallet.
 * Demonstrates data hiding, robust input validation, and immutability of core state.
 */
public class DigitalWallet {

    private final String walletId;
    private final String ownerName;
    private double balance;
    private double dailyLimit;
    private double spentToday;

    public DigitalWallet(String walletId, String ownerName, double initialBalance, double dailyLimit) {
        this.walletId = walletId;
        this.ownerName = ownerName;
        if (initialBalance < 0) {
            System.out.println("Warning: Initial balance cannot be negative. Initializing to Rs 0.0");
            this.balance = 0.0;
        } else {
            this.balance = initialBalance;
        }
        this.dailyLimit = dailyLimit > 0 ? dailyLimit : 1000.0;
        this.spentToday = 0.0;
    }

    public String getWalletId() {
        return walletId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public double getBalance() {
        return balance;
    }

    public double getSpentToday() {
        return spentToday;
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: Amount must be greater than zero.");
            return;
        }
        balance += amount;
        System.out.println("Top-up successful: Added Rs " + amount + ". New balance: Rs " + balance);
    }

    public boolean pay(double amount, String purpose) {
        if (amount <= 0) {
            System.out.println("Payment rejected: Amount must be positive.");
            return false;
        }
        if (spentToday + amount > dailyLimit) {
            System.out.println("Payment rejected: Exceeds daily limit of Rs " + dailyLimit + " (Already spent: Rs " + spentToday + ")");
            return false;
        }
        if (amount > balance) {
            System.out.println("Payment rejected: Insufficient balance (Current: Rs " + balance + ", Needed: Rs " + amount + ")");
            return false;
        }

        balance -= amount;
        spentToday += amount;
        System.out.println("Paid Rs " + amount + " for '" + purpose + "'. Remaining balance: Rs " + balance);
        return true;
    }

    public void resetDailyQuota() {
        spentToday = 0.0;
        System.out.println("Daily spend quota reset for wallet " + walletId);
    }

    public static void main(String[] args) {
        DigitalWallet wallet = new DigitalWallet("W-8821", "Prachi", 1500.0, 500.0);
        System.out.println("Wallet created for " + wallet.getOwnerName() + " with balance Rs " + wallet.getBalance());

        wallet.pay(200.0, "Cafeteria Lunch");
        wallet.pay(400.0, "Bookstore Stationery"); // should exceed daily limit (200 + 400 = 600 > 500)
        wallet.topUp(500.0);
        wallet.pay(250.0, "Printing Services");

        System.out.println("Final Balance: Rs " + wallet.getBalance());
        System.out.println("Total Spent Today: Rs " + wallet.getSpentToday());
    }
}

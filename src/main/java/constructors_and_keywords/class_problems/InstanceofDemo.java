package constructors_and_keywords.class_problems;

/**
 * Live Walkthrough: instanceof Operator for Type Checking.
 * Demonstrates:
 * 1. Safe runtime type verification before downcasting.
 * 2. Polymorphic behavior and handling different subtypes in a single collection.
 */
public class InstanceofDemo {

    public static class FeeAccount {
        protected String accountId;
        protected double balance;

        public FeeAccount(String accountId, double balance) {
            this.accountId = accountId;
            this.balance = balance;
        }

        public void processPayment(double amount) {
            balance -= amount;
            System.out.println("FeeAccount " + accountId + ": Paid in one go. Remaining balance: Rs " + balance);
        }
    }

    public static class HostelFeeAccount extends FeeAccount {
        private int installmentsLeft;

        public HostelFeeAccount(String accountId, double balance, int installmentsLeft) {
            super(accountId, balance);
            this.installmentsLeft = installmentsLeft;
        }

        @Override
        public void processPayment(double amount) {
            balance -= amount;
            installmentsLeft = Math.max(0, installmentsLeft - 1);
            System.out.println("HostelFeeAccount " + accountId + ": Paid in installments. Remaining: Rs "
                    + balance + " (Installments left: " + installmentsLeft + ")");
        }
    }

    public static void auditAndPay(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            HostelFeeAccount hostelAcc = (HostelFeeAccount) account; // Safe downcast
            System.out.print("[Type: HostelFeeAccount] ");
            hostelAcc.processPayment(amount);
        } else if (account instanceof FeeAccount) {
            System.out.print("[Type: General FeeAccount] ");
            account.processPayment(amount);
        } else {
            System.out.println("Unknown account type!");
        }
    }

    public static void main(String[] args) {
        FeeAccount generalAcc = new FeeAccount("GEN-101", 80000.0);
        HostelFeeAccount hostelAcc = new HostelFeeAccount("HST-202", 120000.0, 2);

        FeeAccount[] accounts = { generalAcc, hostelAcc };
        for (FeeAccount acc : accounts) {
            auditAndPay(acc, 30000.0);
        }
    }
}

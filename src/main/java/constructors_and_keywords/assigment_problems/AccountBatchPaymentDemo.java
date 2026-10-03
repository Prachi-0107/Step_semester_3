package constructors_and_keywords.assigment_problems;

/**
 * Category B - Problem M5: Account Batch Payments.
 *
 * Requirements:
 * - processPayment() must use instanceof to correctly dispatch between HostelFeeAccount and a plain FeeAccount.
 * - The batch must track how many of each account type were processed, using simple counters.
 * - Both counters must be printed once, after the full batch has been processed.
 */
public class AccountBatchPaymentDemo {

    public static class FeeAccount {
        protected String accountId;

        public FeeAccount(String accountId) {
            this.accountId = accountId;
        }

        public String getAccountId() {
            return accountId;
        }
    }

    public static class HostelFeeAccount extends FeeAccount {
        public HostelFeeAccount(String accountId) {
            super(accountId);
        }
    }

    // Static counters
    private static int hostelCount = 0;
    private static int dayScholarCount = 0;

    // Suggested signature: void processPayment(FeeAccount account, double amount)
    public static void processPayment(FeeAccount account, double amount) {
        if (account instanceof HostelFeeAccount) {
            hostelCount++;
            System.out.println("Paid in two installments (hostel account)");
        } else if (account instanceof FeeAccount) {
            dayScholarCount++;
            System.out.println("Paid in one go (day-scholar account)");
        }
    }

    public static void main(String[] args) {
        // accounts = {Hostel, Hostel, FeeAccount, FeeAccount}
        FeeAccount[] accounts = {
                new HostelFeeAccount("HST-01"),
                new HostelFeeAccount("HST-02"),
                new FeeAccount("GEN-01"),
                new FeeAccount("GEN-02")
        };
        double paymentAmount = 60000.0;

        for (FeeAccount acc : accounts) {
            processPayment(acc, paymentAmount);
        }

        System.out.println("Hostel accounts processed: " + hostelCount + " | Day-scholar accounts processed: " + dayScholarCount);
    }
}

package constructors_and_keywords.assigment_problems;

/**
 * Category B - Problem M3: Late Fees — Skip the On-Time Accounts.
 *
 * Requirements:
 * - calculateLateFee() and printSummary() must both be final, locked against ever being overridden.
 * - An account with daysLate <= 0 must be skipped entirely, not charged a fee of Rs 0.
 * - The whole batch must be processed in a single pass, printing a summary or a skip message for every account.
 */
public class LateFeeCalculationDemo {

    public static class FeeAccount {
        private String regNo;
        private double totalFee;

        public FeeAccount(String regNo, double totalFee) {
            this.regNo = regNo;
            this.totalFee = totalFee;
        }

        public String getRegNo() {
            return regNo;
        }

        public double getTotalFee() {
            return totalFee;
        }

        // Locked with final keyword: 1% per day late
        public final double calculateLateFee(int daysLate) {
            if (daysLate <= 0) {
                return 0.0;
            }
            return daysLate * 0.01 * totalFee;
        }

        // Locked with final keyword
        public final void printSummary(int daysLate) {
            if (daysLate <= 0) {
                System.out.println(regNo + " - On time, no late fee");
            } else {
                double lateFee = calculateLateFee(daysLate);
                System.out.println(regNo + " | Total Fee: Rs " + totalFee + " | Late Fee: Rs " + lateFee);
            }
        }
    }

    public static void main(String[] args) {
        String[] regNos = {"RA001", "RA002", "RA003", "RA004"};
        double[] totalFees = {200000.0, 150000.0, 180000.0, 220000.0};
        int[] daysLate = {10, 0, -2, 5};

        FeeAccount[] accounts = new FeeAccount[regNos.length];
        for (int i = 0; i < regNos.length; i++) {
            accounts[i] = new FeeAccount(regNos[i], totalFees[i]);
        }

        // Process batch in a single pass
        for (int i = 0; i < accounts.length; i++) {
            accounts[i].printSummary(daysLate[i]);
        }
    }
}

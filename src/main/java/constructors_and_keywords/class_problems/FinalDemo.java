package constructors_and_keywords.class_problems;

/**
 * Live Walkthrough: The 'final' Keyword in Java.
 * Demonstrates:
 * 1. final variable: cannot be reassigned once initialized.
 * 2. final method: locked against being overridden by any subclass.
 * 3. final class: closed against extension (cannot be inherited).
 */
public class FinalDemo {

    public static class FeePolicy {
        // final field: must be initialized in declaration or constructor, immutable thereafter
        public final double lateFeePerDay;

        public FeePolicy(double lateFeePerDay) {
            this.lateFeePerDay = lateFeePerDay;
        }

        // final method: subclasses can never alter this calculation logic
        public final double calculateLateFee(int daysLate) {
            if (daysLate <= 0) return 0.0;
            return daysLate * lateFeePerDay;
        }
    }

    // final class: prevents subclassing completely
    public static final class ImmutableInstitutionConfig {
        public static final String INSTITUTION_CODE = "SRMIST-KTR";
        public static final int ACCREDITATION_GRADE = 1; // A++
    }

    public static void main(String[] args) {
        FeePolicy policy = new FeePolicy(100.0);
        System.out.println("Late fee for 5 days: Rs " + policy.calculateLateFee(5));
        System.out.println("Institution: " + ImmutableInstitutionConfig.INSTITUTION_CODE);
    }
}

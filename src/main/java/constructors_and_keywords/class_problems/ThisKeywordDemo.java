package constructors_and_keywords.class_problems;

/**
 * Live Walkthrough: The 'this' Keyword.
 * Demonstrates:
 * 1. Disambiguating shadowed instance fields when parameter names match field names.
 * 2. Invoking current instance methods.
 * 3. Passing 'this' as an argument to another method or callback.
 */
public class ThisKeywordDemo {

    public static class StudentAccount {
        private String regNo;
        private String name;
        private double balance;

        public StudentAccount(String regNo, String name, double balance) {
            // 'this.field' refers to the instance field; 'field' refers to the parameter
            this.regNo = regNo;
            this.name = name;
            this.balance = balance;
        }

        public void credit(double amount) {
            this.balance += amount;
            AccountPrinter.logTransaction(this, "CREDIT", amount);
        }

        public String getRegNo() {
            return this.regNo;
        }

        public String getName() {
            return this.name;
        }

        public double getBalance() {
            return this.balance;
        }
    }

    public static class AccountPrinter {
        public static void logTransaction(StudentAccount account, String type, double amount) {
            System.out.println("[" + type + "] RegNo: " + account.getRegNo() + " (" + account.getName() + ")"
                    + " Amount: Rs " + amount + " | New Balance: Rs " + account.getBalance());
        }
    }

    public static void main(String[] args) {
        StudentAccount acc = new StudentAccount("RA2311003010001", "Karthik", 5000.0);
        acc.credit(1500.0);
    }
}

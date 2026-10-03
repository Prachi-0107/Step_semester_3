package constructors_and_keywords.class_problems;

/**
 * Live Walkthrough: Constructor Overloading and this() Chaining.
 * Demonstrates:
 * 1. Offering multiple constructor signatures for different caller needs.
 * 2. Eliminating duplicated assignment logic using this(...) constructor delegation.
 */
public class OverloadingDemo {

    public static class Course {
        String code;
        String title;
        int credits;
        int labCredits;

        // Master 4-parameter constructor
        public Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        // Chained 3-parameter constructor for theory-only courses
        public Course(String code, String title, int credits) {
            this(code, title, credits, 0); // delegates to 4-parameter constructor
        }

        public int totalCredits() {
            return credits + labCredits;
        }

        public void printSummary() {
            System.out.println(code + " | " + title + " | Total Credits: " + totalCredits());
        }
    }

    public static void main(String[] args) {
        Course dsa = new Course("21CSC201J", "Data Structures & Algorithms", 4);
        Course dsaLab = new Course("21CSC205L", "DSA Practical Lab", 3, 1);

        dsa.printSummary();
        dsaLab.printSummary();
    }
}

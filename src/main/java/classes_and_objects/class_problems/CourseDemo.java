package classes_and_objects.class_problems;

/**
 * Live Session Walkthrough: Constructor Overloading and this() Chaining.
 * Demonstrates chaining overloaded constructors to eliminate duplicated initialization logic.
 */
public class CourseDemo {

    public static class CourseEntry {
        String code;
        String title;
        int credits;
        int labCredits;

        public CourseEntry(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        public CourseEntry(String code, String title, int credits) {
            this(code, title, credits, 0); // Constructor chaining
        }

        public int totalCredits() {
            return credits + labCredits;
        }
    }

    public static void main(String[] args) {
        CourseEntry theory = new CourseEntry("21CSC201J", "Data Structures", 4);
        CourseEntry lab = new CourseEntry("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(theory.code + " total credits: " + theory.totalCredits());
        System.out.println(lab.code + " total credits: " + lab.totalCredits());
    }
}

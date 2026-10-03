package constructors_and_keywords.class_problems;

/**
 * Live Walkthrough: Static Initialization Block.
 * Demonstrates:
 * 1. Static block runs exactly once when the class is loaded into the JVM.
 * 2. It executes before any constructor or instance block.
 * 3. Useful for one-time initialization of complex static constants/lookups.
 */
public class StaticBlockDemo {

    public static class CollegeRegistry {
        public static String collegeName;
        public static String academicYear;
        public static int studentCounter;

        // Static block: executed once when class is referenced for the first time
        static {
            collegeName = "SRM Institute of Science and Technology";
            academicYear = "2026-2027";
            studentCounter = 0;
            System.out.println(">>> Static initialization block executed: Registry configured once.");
        }

        private String studentName;
        private String regId;

        public CollegeRegistry(String studentName) {
            this.studentName = studentName;
            studentCounter++;
            this.regId = "SRM-" + academicYear + "-" + String.format("%04d", studentCounter);
            System.out.println("Enrolled student: " + studentName + " | ID: " + regId);
        }
    }

    public static void main(String[] args) {
        System.out.println("Main method started.");
        System.out.println("Creating first student...");
        new CollegeRegistry("Aarav");

        System.out.println("\nCreating second student...");
        new CollegeRegistry("Diya");

        System.out.println("\nTotal students registered: " + CollegeRegistry.studentCounter);
    }
}

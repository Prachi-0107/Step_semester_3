package classes_and_objects.class_problems;

/**
 * Live Session Walkthrough: Instance vs Static Members.
 * Demonstrates shared class-level state (collegeName, studentCount)
 * vs per-instance attributes (name, attendance).
 */
public class StudentDemo {

    public static class StudentRecord {
        String name;
        int attendance;

        public static String collegeName = "SRM Institute of Science and Technology";
        public static int studentCount = 0;

        public StudentRecord(String name, int attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++;
        }

        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        new StudentRecord("Student1", 85);
        new StudentRecord("Student2", 90);

        // Accessing static method directly via class name
        StudentRecord.printCollegeInfo();
    }
}

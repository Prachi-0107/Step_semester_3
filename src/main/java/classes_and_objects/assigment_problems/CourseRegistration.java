package classes_and_objects.assigment_problems;

/**
 * Assignment Problem 3: Course Registration System with Constructor Chaining.
 * Demonstrates constructor overloading, this() chaining, and business validation.
 */
public class CourseRegistration {

    public static class Course {
        private String courseCode;
        private String title;
        private int lectureCredits;
        private int labCredits;
        private int projectCredits;

        // Master constructor
        public Course(String courseCode, String title, int lectureCredits, int labCredits, int projectCredits) {
            this.courseCode = courseCode;
            this.title = title;
            this.lectureCredits = lectureCredits;
            this.labCredits = labCredits;
            this.projectCredits = projectCredits;
        }

        // Chained constructor: Theory + Lab (No project)
        public Course(String courseCode, String title, int lectureCredits, int labCredits) {
            this(courseCode, title, lectureCredits, labCredits, 0);
        }

        // Chained constructor: Theory only (No lab, no project)
        public Course(String courseCode, String title, int lectureCredits) {
            this(courseCode, title, lectureCredits, 0, 0);
        }

        public int getTotalCredits() {
            return lectureCredits + labCredits + projectCredits;
        }

        public void printSummary() {
            System.out.printf("%-10s | %-25s | L:%d Lab:%d P:%d | Total: %d Credits%n",
                    courseCode, title, lectureCredits, labCredits, projectCredits, getTotalCredits());
        }
    }

    public static void main(String[] args) {
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        Course labCourse = new Course("21CSC205L", "Operating Systems", 3, 1);
        Course capstoneCourse = new Course("21CSP301", "Industry Capstone", 2, 1, 3);

        System.out.println("Registered Courses:");
        theoryCourse.printSummary();
        labCourse.printSummary();
        capstoneCourse.printSummary();

        int grandTotal = theoryCourse.getTotalCredits() + labCourse.getTotalCredits() + capstoneCourse.getTotalCredits();
        System.out.println("Grand Total Credits Registered: " + grandTotal);
    }
}

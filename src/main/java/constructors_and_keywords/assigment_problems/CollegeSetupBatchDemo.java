package constructors_and_keywords.assigment_problems;

/**
 * Category B - Problem M4: One-Time College Setup, Many Students.
 *
 * Requirements:
 * - collegeName and academicYear must be set exactly once, through a static block — never repeated per object.
 * - Creating multiple students in a loop must not cause the static block to run more than once.
 * - Every student created in the batch must print a short confirmation line.
 */
public class CollegeSetupBatchDemo {

    public static class SrmStudent {
        public static String collegeName;
        public static String academicYear;

        // Static initialization block runs exactly once upon class loading
        static {
            collegeName = "SRM Institute of Science and Technology";
            academicYear = "2026-2027";
            System.out.println("College info loaded");
        }

        private String name;

        public SrmStudent(String name) {
            this.name = name;
            System.out.println("Student record created: " + this.name);
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        String[] names = {"Ravi", "Meera", "Karthik", "Divya", "Anitha"};

        SrmStudent[] batch = new SrmStudent[names.length];
        for (int i = 0; i < names.length; i++) {
            batch[i] = new SrmStudent(names[i]);
        }
    }
}

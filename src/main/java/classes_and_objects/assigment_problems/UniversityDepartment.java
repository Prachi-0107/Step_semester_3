package classes_and_objects.assigment_problems;

/**
 * Assignment Problem 5: University Department Management.
 * Demonstrates static class-level variables/methods vs instance-level data.
 */
public class UniversityDepartment {

    // Instance attributes
    private String departmentName;
    private String hodName;
    private int enrolledStudents;

    // Static class-level attributes
    public static String universityName = "SRM Institute of Science and Technology";
    public static int totalDepartments = 0;
    public static int totalStudentsAcrossAllDepts = 0;

    public UniversityDepartment(String departmentName, String hodName, int enrolledStudents) {
        this.departmentName = departmentName;
        this.hodName = hodName;
        this.enrolledStudents = enrolledStudents;
        totalDepartments++;
        totalStudentsAcrossAllDepts += enrolledStudents;
    }

    public void displayDepartmentDetails() {
        System.out.printf("Dept: %-25s | HOD: %-15s | Enrolled: %d%n", departmentName, hodName, enrolledStudents);
    }

    public static void printUniversitySummary() {
        System.out.println("==================================================");
        System.out.println("University: " + universityName);
        System.out.println("Total Registered Departments: " + totalDepartments);
        System.out.println("Total Enrolled Students: " + totalStudentsAcrossAllDepts);
        System.out.println("==================================================");
    }

    public static void main(String[] args) {
        UniversityDepartment cse = new UniversityDepartment("Computer Science & Eng", "Dr. A. Sharma", 750);
        UniversityDepartment ece = new UniversityDepartment("Electronics & Comm Eng", "Dr. B. Raman", 420);
        UniversityDepartment mech = new UniversityDepartment("Mechanical Engineering", "Dr. C. Verma", 280);

        System.out.println("Department Roster:");
        cse.displayDepartmentDetails();
        ece.displayDepartmentDetails();
        mech.displayDepartmentDetails();

        // Accessing static method directly via class name
        UniversityDepartment.printUniversitySummary();
    }
}

package constructors_and_keywords.assigment_problems;

/**
 * Category B - Problem M2: Payroll Batch Bonus Round.
 *
 * Requirements:
 * - Employee's constructor and raiseSalary() must each resolve a genuine field/parameter naming clash using this.
 * - Every employee in the array must receive the identical bonus amount in a single pass.
 * - Each employee's final salary must be printed after the raise is applied.
 */
public class PayrollBonusDemo {

    public static class Employee {
        private String empId;
        private double salary;

        public Employee(String empId, double salary) {
            // Resolving parameter/field name clash with 'this'
            this.empId = empId;
            this.salary = salary;
        }

        // Suggested signature: void raiseSalary(double salary)
        public void raiseSalary(double salary) {
            // Parameter 'salary' represents the raise amount; adding it to 'this.salary'
            this.salary = this.salary + salary;
        }

        public String getEmpId() {
            return this.empId;
        }

        public double getSalary() {
            return this.salary;
        }

        public void printSummary() {
            System.out.println(this.empId + " | Final Salary: Rs " + this.salary);
        }
    }

    public static void main(String[] args) {
        String[] empIds = {"E-101", "E-102", "E-103", "E-104"};
        double[] startingSalaries = {40000.0, 55000.0, 62000.0, 48000.0};
        double bonusAmount = 5000.0;

        Employee[] employees = new Employee[empIds.length];
        for (int i = 0; i < empIds.length; i++) {
            employees[i] = new Employee(empIds[i], startingSalaries[i]);
        }

        // Apply bonus to each in a single pass and print final salary
        for (Employee emp : employees) {
            emp.raiseSalary(bonusAmount);
            emp.printSummary();
        }
    }
}

package classes_and_objects.class_problems;

/**
 * Live Session Walkthrough: Converting Parallel Arrays to Object-Oriented Design.
 * Demonstrates how bundling related attributes into a single PlacementRecord
 * prevents data synchronization errors.
 */
public class PlacementRecordDemo {

    public static class Record {
        String studentName;
        String company;
        double packageLpa;

        public Record(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }

        public void printRecord() {
            System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
        }
    }

    public static void main(String[] args) {
        Record[] records = new Record[]{
            new Record("Ravi", "TCS", 4.5),
            new Record("Anitha", "Zoho", 6.2),
            new Record("Karthik", "Infosys", 4.0)
        };

        for (Record record : records) {
            record.printRecord();
        }
    }
}

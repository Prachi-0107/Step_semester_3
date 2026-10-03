package classes_and_objects.assigment_problems;

/**
 * Assignment Problem 1: Batch Placement Tracker.
 * Demonstrates an array of objects, data aggregation, and encapsulation.
 */
public class StudentPlacementTracker {

    public static class Placement {
        private String studentName;
        private String company;
        private double packageLpa;

        public Placement(String studentName, String company, double packageLpa) {
            this.studentName = studentName;
            this.company = company;
            this.packageLpa = packageLpa;
        }

        public String getStudentName() {
            return studentName;
        }

        public String getCompany() {
            return company;
        }

        public double getPackageLpa() {
            return packageLpa;
        }

        public void printDetails() {
            System.out.println(studentName + " -> " + company + " @ " + packageLpa + " LPA");
        }
    }

    public static class PlacementManager {
        private Placement[] placements;
        private int count;

        public PlacementManager(int capacity) {
            placements = new Placement[capacity];
            count = 0;
        }

        public void addPlacement(String name, String company, double lpa) {
            if (count < placements.length) {
                placements[count++] = new Placement(name, company, lpa);
            }
        }

        public void displayAll() {
            System.out.println("--- All Placement Records ---");
            for (int i = 0; i < count; i++) {
                placements[i].printDetails();
            }
        }

        public Placement getHighestPackage() {
            if (count == 0) return null;
            Placement best = placements[0];
            for (int i = 1; i < count; i++) {
                if (placements[i].getPackageLpa() > best.getPackageLpa()) {
                    best = placements[i];
                }
            }
            return best;
        }

        public double calculateAveragePackage() {
            if (count == 0) return 0.0;
            double total = 0.0;
            for (int i = 0; i < count; i++) {
                total += placements[i].getPackageLpa();
            }
            return total / count;
        }
    }

    public static void main(String[] args) {
        PlacementManager manager = new PlacementManager(5);
        manager.addPlacement("Ravi", "TCS", 4.5);
        manager.addPlacement("Anitha", "Zoho", 6.2);
        manager.addPlacement("Karthik", "Infosys", 4.0);
        manager.addPlacement("Pooja", "Google", 32.0);

        manager.displayAll();

        Placement top = manager.getHighestPackage();
        if (top != null) {
            System.out.println("Top Placement: " + top.getStudentName() + " (" + top.getPackageLpa() + " LPA)");
        }
        System.out.printf("Average Package: %.2f LPA%n", manager.calculateAveragePackage());
    }
}

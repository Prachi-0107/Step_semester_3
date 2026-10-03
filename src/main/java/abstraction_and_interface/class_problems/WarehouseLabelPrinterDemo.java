package abstraction_and_interface.class_problems;

/**
 * Problem 2 (Basic): Warehouse Label Printer.
 *
 * Requirements:
 * - Define an interface Printable with a method printLabel() returning a String.
 * - PackageBox and Invoice must both implement Printable directly,
 *   with no relationship to each other or to any shared parent class.
 * - Write a static method printAll(Printable[] items) that loops through a mixed array
 *   and calls printLabel() on each.
 */
public class WarehouseLabelPrinterDemo {

    public interface Printable {
        String printLabel();
    }

    public static class PackageBox implements Printable {
        private String trackingId;

        public PackageBox(String trackingId) {
            this.trackingId = trackingId;
        }

        @Override
        public String printLabel() {
            return "Package label: " + trackingId;
        }
    }

    public static class Invoice implements Printable {
        private String invoiceNumber;

        public Invoice(String invoiceNumber) {
            this.invoiceNumber = invoiceNumber;
        }

        @Override
        public String printLabel() {
            return "Invoice label: " + invoiceNumber;
        }
    }

    public static void printAll(Printable[] items) {
        for (Printable item : items) {
            System.out.println(item.printLabel());
        }
    }

    public static void main(String[] args) {
        PackageBox p = new PackageBox("TRK-88");
        System.out.println(p.printLabel());

        Invoice i = new Invoice("INV-42");
        System.out.println(i.printLabel());

        System.out.println("\nPrinting all via polymorphic interface dispatch:");
        printAll(new Printable[]{ p, i });
    }
}

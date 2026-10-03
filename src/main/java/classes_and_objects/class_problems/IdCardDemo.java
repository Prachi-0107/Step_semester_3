package classes_and_objects.class_problems;

/**
 * Live Session Walkthrough: Reference Copies vs Distinct Objects.
 * Demonstrates pointer aliasing, reference equality (==), and distinct heap allocation.
 */
public class IdCardDemo {

    public static class Card {
        String name;
        int booksIssued;

        public Card(String name, int booksIssued) {
            this.name = name;
            this.booksIssued = booksIssued;
        }
    }

    public static void main(String[] args) {
        Card ravi = new Card("Ravi", 0);
        Card duplicate = ravi; // Reference copy
        duplicate.booksIssued = 3;

        Card separate = new Card("Ravi", 3); // Separate heap object

        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}

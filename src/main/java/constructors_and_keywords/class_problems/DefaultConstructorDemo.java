package constructors_and_keywords.class_problems;

/**
 * Live Walkthrough: Default Constructor vs Parameterized Constructor.
 * Demonstrates:
 * 1. Default no-arg constructor provided automatically by the compiler.
 * 2. Default values assigned to uninitialized fields (0, null, false).
 * 3. Loss of the default constructor once an explicit constructor is defined.
 */
public class DefaultConstructorDemo {

    // Class with no constructor written - Java compiler supplies default no-arg constructor
    public static class DefaultBook {
        String title;
        String isbn;
        boolean issued;
        int pageCount;

        public void printState() {
            System.out.println("DefaultBook State -> title: " + title + ", isbn: " + isbn
                    + ", issued: " + issued + ", pageCount: " + pageCount);
        }
    }

    // Class with explicit parameterized constructor - default constructor is withdrawn
    public static class ParameterizedBook {
        String title;
        String isbn;
        boolean issued;

        public ParameterizedBook(String title, String isbn) {
            this.title = title;
            this.isbn = isbn;
            this.issued = false;
        }

        public void printState() {
            System.out.println("ParameterizedBook State -> title: " + title + ", isbn: " + isbn + ", issued: " + issued);
        }
    }

    public static void main(String[] args) {
        System.out.println("--- 1. Testing Default (Free) Constructor ---");
        DefaultBook freeBook = new DefaultBook();
        freeBook.printState(); // Shows default values: null, null, false, 0

        System.out.println("\n--- 2. Testing Parameterized Constructor ---");
        ParameterizedBook manualBook = new ParameterizedBook("Effective Java", "978-0134685991");
        manualBook.printState();
    }
}

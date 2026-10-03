package constructors_and_keywords.assigment_problems;

/**
 * Category B - Problem M1: Library Book Cataloguing.
 *
 * Requirements:
 * - LibraryBook must offer two constructors linked through this() chaining.
 * - A book with no confirmed ISBN must default to "PENDING", never left blank or null.
 * - Every entry in the batch must be processed and its status printed in a single pass.
 */
public class LibraryBookCatalogDemo {

    public static class LibraryBook {
        private String title;
        private String isbn;
        private boolean catalogued;

        public LibraryBook(String title, String isbn) {
            this.title = title;
            if (isbn == null || isbn.trim().isEmpty()) {
                this.isbn = "PENDING";
            } else {
                this.isbn = isbn;
            }
            this.catalogued = true;
        }

        // Chained constructor using this(...)
        public LibraryBook(String title) {
            this(title, "PENDING");
        }

        public String getTitle() {
            return title;
        }

        public String getIsbn() {
            return isbn;
        }

        public boolean isCatalogued() {
            return catalogued;
        }

        public void printCatalogEntry() {
            System.out.println(title + " | " + isbn + " | Catalogued: " + catalogued);
        }
    }

    public static void main(String[] args) {
        String[] titles = {"Clean Code", "Untitled Draft", "1984", "Notes"};
        String[] isbns = {"978-0132350884", "", "9780451524935", ""};

        LibraryBook[] batch = new LibraryBook[titles.length];

        // Process batch in a single pass
        for (int i = 0; i < titles.length; i++) {
            if (isbns[i] == null || isbns[i].trim().isEmpty()) {
                batch[i] = new LibraryBook(titles[i]);
            } else {
                batch[i] = new LibraryBook(titles[i], isbns[i]);
            }
            batch[i].printCatalogEntry();
        }
    }
}

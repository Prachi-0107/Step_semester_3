package classes_and_objects.assigment_problems;

/**
 * Assignment Problem 4: Library Membership Card Identity & Sharing.
 * Demonstrates reference copying vs independent object instantiation,
 * aliasing pitfalls, and state mutation.
 */
public class LibraryMembershipCard {

    private String memberName;
    private String membershipId;
    private int booksIssued;
    private static final int MAX_BOOKS_ALLOWED = 5;

    public LibraryMembershipCard(String memberName, String membershipId, int booksIssued) {
        this.memberName = memberName;
        this.membershipId = membershipId;
        this.booksIssued = booksIssued;
    }

    public String getMemberName() {
        return memberName;
    }

    public String getMembershipId() {
        return membershipId;
    }

    public int getBooksIssued() {
        return booksIssued;
    }

    public void issueBooks(int count) {
        if (booksIssued + count > MAX_BOOKS_ALLOWED) {
            System.out.println("Cannot issue " + count + " books. Maximum allowance of " + MAX_BOOKS_ALLOWED + " exceeded.");
        } else {
            booksIssued += count;
            System.out.println(count + " book(s) issued to " + memberName + ". Current total: " + booksIssued);
        }
    }

    public static void main(String[] args) {
        // Original member card
        LibraryMembershipCard card1 = new LibraryMembershipCard("Ravi Kumar", "LIB-101", 1);

        // Reference copy (pointing to identical memory location)
        LibraryMembershipCard card1Alias = card1;

        // Distinct object with identical initial values
        LibraryMembershipCard card2 = new LibraryMembershipCard("Ravi Kumar", "LIB-101", 1);

        System.out.println("Identity Check (card1 == card1Alias): " + (card1 == card1Alias)); // true
        System.out.println("Identity Check (card1 == card2): " + (card1 == card2));           // false

        // Mutating through alias
        System.out.println("\nIssuing 2 more books via alias reference...");
        card1Alias.issueBooks(2);

        System.out.println("Books on card1: " + card1.getBooksIssued());       // 3
        System.out.println("Books on card1Alias: " + card1Alias.getBooksIssued()); // 3
        System.out.println("Books on card2 (independent): " + card2.getBooksIssued()); // 1
    }
}

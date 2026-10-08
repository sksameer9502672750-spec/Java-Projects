import java.util.ArrayList;
import java.util.Scanner;

class Book {
    int bookId;
    String title;
    String author;
    boolean issued;
    int issuedMemberId;
    int issueDays;

    Book(int bookId, String title, String author) {
        this.bookId = bookId;
        this.title = title;
        this.author = author;
        this.issued = false;
        this.issuedMemberId = 0;
        this.issueDays = 0;
    }

    void display() {
        System.out.println("--------------------------------");
        System.out.println("Book ID    : " + bookId);
        System.out.println("Title      : " + title);
        System.out.println("Author     : " + author);
        System.out.println("Status     : " +
                (issued ? "Issued" : "Available"));

        if (issued) {
            System.out.println("Member ID  : " + issuedMemberId);
            System.out.println("Issue Days : " + issueDays);
        }

        System.out.println("--------------------------------");
    }
}

class Member {
    int memberId;
    String name;

    Member(int memberId, String name) {
        this.memberId = memberId;
        this.name = name;
    }

    void display() {
        System.out.println("Member ID : " + memberId);
        System.out.println("Name      : " + name);
    }
}

public class LibraryManagementSystem {

    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Member> members = new ArrayList<>();

    static Scanner sc = new Scanner(System.in);

    static final int ALLOWED_DAYS = 14;
    static final double FINE_PER_DAY = 5.0;

    // Find book using Book ID
    static Book findBook(int id) {
        for (Book book : books) {
            if (book.bookId == id) {
                return book;
            }
        }
        return null;
    }

    // Find member using Member ID
    static Member findMember(int id) {
        for (Member member : members) {
            if (member.memberId == id) {
                return member;
            }
        }
        return null;
    }

    // Add a new book
    static void addBook() {

        System.out.println("\n--- ADD BOOK ---");

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findBook(id) != null) {
            System.out.println("Book ID already exists!");
            return;
        }

        System.out.print("Enter Book Title: ");
        String title = sc.nextLine();

        System.out.print("Enter Author Name: ");
        String author = sc.nextLine();

        Book book = new Book(id, title, author);
        books.add(book);

        System.out.println("Book added successfully!");
    }

    // Display all books
    static void viewBooks() {

        if (books.isEmpty()) {
            System.out.println("\nNo books available.");
            return;
        }

        System.out.println("\n--- LIBRARY BOOKS ---");

        for (Book book : books) {
            book.display();
        }
    }

    // Add library member
    static void addMember() {

        System.out.println("\n--- ADD MEMBER ---");

        System.out.print("Enter Member ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        if (findMember(id) != null) {
            System.out.println("Member ID already exists!");
            return;
        }

        System.out.print("Enter Member Name: ");
        String name = sc.nextLine();

        Member member = new Member(id, name);
        members.add(member);

        System.out.println("Member added successfully!");
    }

    // View members
    static void viewMembers() {

        if (members.isEmpty()) {
            System.out.println("\nNo members registered.");
            return;
        }

        System.out.println("\n--- LIBRARY MEMBERS ---");

        for (Member member : members) {
            member.display();
            System.out.println("-----------------------");
        }
    }

    // Issue a book
    static void issueBook() {

        System.out.println("\n--- ISSUE BOOK ---");

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

        Book book = findBook(bookId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (book.issued) {
            System.out.println("Book is already issued.");
            return;
        }

        System.out.print("Enter Member ID: ");
        int memberId = sc.nextInt();

        Member member = findMember(memberId);

        if (member == null) {
            System.out.println("Member not found!");
            return;
        }

        System.out.print("Enter number of days book is issued: ");
        int days = sc.nextInt();

        if (days <= 0) {
            System.out.println("Invalid number of days.");
            return;
        }

        book.issued = true;
        book.issuedMemberId = memberId;
        book.issueDays = days;

        System.out.println("\nBook issued successfully!");
        System.out.println("Book  : " + book.title);
        System.out.println("Member: " + member.name);
    }

    // Return a book
    static void returnBook() {

        System.out.println("\n--- RETURN BOOK ---");

        System.out.print("Enter Book ID: ");
        int bookId = sc.nextInt();

        Book book = findBook(bookId);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (!book.issued) {
            System.out.println("This book is not issued.");
            return;
        }

        int overdueDays = 0;
        double fine = 0;

        if (book.issueDays > ALLOWED_DAYS) {
            overdueDays = book.issueDays - ALLOWED_DAYS;
            fine = overdueDays * FINE_PER_DAY;
        }

        System.out.println("\n======= RETURN DETAILS =======");
        System.out.println("Book Title   : " + book.title);
        System.out.println("Issued Days  : " + book.issueDays);
        System.out.println("Allowed Days : " + ALLOWED_DAYS);
        System.out.println("Overdue Days : " + overdueDays);
        System.out.println("Fine         : Rs. " + fine);
        System.out.println("==============================");

        book.issued = false;
        book.issuedMemberId = 0;
        book.issueDays = 0;

        System.out.println("Book returned successfully!");
    }

    // Search for a book
    static void searchBook() {

        System.out.println("\n--- SEARCH BOOK ---");

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        Book book = findBook(id);

        if (book != null) {
            book.display();
        } else {
            System.out.println("Book not found!");
        }
    }

    // Check book availability
    static void checkAvailability() {

        System.out.println("\n--- CHECK AVAILABILITY ---");

        System.out.print("Enter Book ID: ");
        int id = sc.nextInt();

        Book book = findBook(id);

        if (book == null) {
            System.out.println("Book not found!");
            return;
        }

        if (book.issued) {
            System.out.println("Book is currently NOT AVAILABLE.");
        } else {
            System.out.println("Book is AVAILABLE.");
        }
    }

    // Main menu
    static void menu() {

        while (true) {

            System.out.println("\n=================================");
            System.out.println("     LIBRARY MANAGEMENT SYSTEM");
            System.out.println("=================================");

            System.out.println("1. Add Book");
            System.out.println("2. View All Books");
            System.out.println("3. Add Member");
            System.out.println("4. View Members");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("7. Search Book");
            System.out.println("8. Check Book Availability");
            System.out.println("9. Exit");

            System.out.print("\nEnter your choice: ");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addBook();
                    break;

                case 2:
                    viewBooks();
                    break;

                case 3:
                    addMember();
                    break;

                case 4:
                    viewMembers();
                    break;

                case 5:
                    issueBook();
                    break;

                case 6:
                    returnBook();
                    break;

                case 7:
                    searchBook();
                    break;

                case 8:
                    checkAvailability();
                    break;

                case 9:
                    System.out.println(
                            "\nThank you for using Library Management System!");
                    return;

                default:
                    System.out.println(
                            "Invalid choice. Please try again.");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println(
                "Welcome to Library Management System");

        menu();

        sc.close();
    }
}


import ParikshitzSitaula.Services.Librarian;
import ParikshitzSitaula.entities.Book;
import ParikshitzSitaula.entities.Users;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Librarian librarian = new Librarian();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n====== Library Management System ======");
            System.out.println("1. Add Book");
            System.out.println("2. Add User");
            System.out.println("3. List All Books");
            System.out.println("4. List All Users");
            System.out.println("5. Issue Book");
            System.out.println("6. Return Book");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter book title: ");
                        String title = scanner.nextLine();
                        System.out.print("Enter author name: ");
                        String author = scanner.nextLine();
                        librarian.addBook(new Book(0, title, author));
                        System.out.println("Book added successfully.");
                        break;

                    case 2:
                        System.out.print("Enter user name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter user email: ");
                        String email = scanner.nextLine();
                        librarian.addUser(new Users(0, name));
                        System.out.println("User added successfully.");
                        break;

                    case 3:
                        List<Book> books = librarian.getAllBooks();
                        System.out.println("\nAvailable Books:");
                        books.forEach(System.out::println);
                        break;

                    case 4:
                        List<Users> users = librarian.getAllUsers();
                        System.out.println("\nRegistered Users:");
                        users.forEach(user -> System.out.println(user.getId() + " | " + user.getName() ));
                        break;

                    case 5:
                        System.out.print("Enter book ID to issue: ");
                        int bookId = scanner.nextInt();
                        System.out.print("Enter user ID: ");
                        int userId = scanner.nextInt();
                        librarian.issueBook(bookId, userId);
                        System.out.println("Book issued successfully.");
                        break;

                    case 6:
                        System.out.print("Enter book ID to return: ");
                        int returnBookId = scanner.nextInt();
                        librarian.returnBook(returnBookId);
                        System.out.println("Book returned successfully.");
                        break;

                    case 0:
                        System.out.println("Exiting... Goodbye!");
                        scanner.close();
                        return;

                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (SQLException e) {
                System.err.println("Database error: " + e.getMessage());
            } catch (Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
            }
        }
    }
}

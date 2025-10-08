/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author madvillain
 */
public class BookService {
    private List<Book> books = new ArrayList<>();

    public static int readInt(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }
        int value = sc.nextInt();
        return value;
    }

    public void addBook(Scanner sc) {
        System.out.println("\n=== Add New Book ===");

        System.out.print("Enter book ID: ");
        int id = readInt(sc);

        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Enter published year: ");
        int publishedYear = readInt(sc);

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        Book book = new Book(id, publishedYear, isbn, title, author, category, true);
        books.add(book);
        System.out.println("Book added successfully!");
    }

    public void removeBook(Scanner sc) {
        if (books.isEmpty()) {
            System.out.println("No books available to remove.");
            return;
        }

        System.out.println("\n=== Remove Book ===");
        System.out.println("Enter Book ID to Remove");
        System.out.print("Enter choice: ");

        int id = readInt(sc);

        Book bookToRemove = searchById(id);

        if (bookToRemove == null) {
            System.out.println("No books found.");
            return;
        }

        books.remove(bookToRemove);
        System.out.println("Book removed successfully!");
    }

    public Book searchById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                System.out.println(book);
                return book;
            }
        }
        System.out.println("No books found.");
        return null;
    }

    public Book searchByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                System.out.println(book);
                return book;
            }
        }
        System.out.println("No books found.");
        return null;
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println(book);
                return book;
            }
        }
        System.out.println("No books found.");
        return null;
    }

    public Book searchByPublishedYear(int publishedYear) {
        for (Book book : books) {
            if (book.getPublishedYear() == publishedYear) {
                System.out.println(book);
                return book;
            }
        }
        System.out.println("No books found.");
        return null;
    }

    public Book searchByCategory(String category) {
        for (Book book : books) {
            if (book.getCategory().equalsIgnoreCase(category)) {
                return book;
            }
        }
        System.out.println("No books found.");
        return null;
    }

    public void borrowBook(Scanner sc) {
        if (books.isEmpty()) {
            System.out.println("No books available to borrow.");
            return;
        }

        System.out.println("\n=== Borrow Book ===");
        System.out.print("Enter Book ID to borrow: ");
        int id = readInt(sc);

        Book bookToBorrow = null;
        for (Book book : books) {
            if (book.getId() == id) {
                bookToBorrow = book;
                break;
            }
        }

        if (bookToBorrow == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!bookToBorrow.isIsAvailable()) {
            System.out.println("Book is already borrowed.");
            return;
        }

        bookToBorrow.setIsAvailable(false);
        System.out.println("Book borrowed successfully!");
        System.out.println("Borrowed: " + bookToBorrow.getTitle());
    }

    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("\n=== All Books ===");
        for (Book book : books) {
            System.out.println(book);
        }
    }
}

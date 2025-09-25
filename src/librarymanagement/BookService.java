/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import librarymanagement.Book;

/**
 *
 * @author madvillain
 */
public class BookService {
    private List<Book> books = new ArrayList<>();

    public void addBook(Scanner sc) {
        System.out.println("=== Add New Book ===");

        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Enter published year: ");
        int publishedYear = sc.nextInt();
        sc.nextLine(); // consume newline

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        // Create new book (assuming available by default)
        Book book = new Book(id, publishedYear, isbn, title, author, category, true);
        books.add(book);
        System.out.println("Book added successfully!");
    }
    
    public void removeBook(Scanner sc) {
        if (books.isEmpty()) {
            System.out.println("No books available to remove.");
            return;
        }

        System.out.println("=== Remove Book ===");
        System.out.println("Search by:");
        System.out.println("1. ID");
        System.out.println("2. ISBN");
        System.out.println("3. Title");
        System.out.print("Enter choice: ");

        int searchChoice = sc.nextInt();
        sc.nextLine(); // consume newline

        Book bookToRemove = null;

        switch (searchChoice) {
            case 1:
                System.out.print("Enter book ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                bookToRemove = searchById(id);
                break;
            case 2:
                System.out.print("Enter ISBN: ");
                String isbn = sc.nextLine();
                bookToRemove = searchByISBN(isbn);
                break;
            case 3:
                System.out.print("Enter title: ");
                String title = sc.nextLine();
                bookToRemove = searchByTitle(title);
                break;
            default:
                System.out.println("Invalid choice.");
                return;
        }

        if (bookToRemove == null) {
            System.out.println("Book not found!");
            return;
        }

        // Show the book details and remove immediately
        System.out.println("\nRemoving book:");
        displayBook(bookToRemove);

        books.remove(bookToRemove);
        System.out.println("Book removed successfully!");
    }
    
    public Book searchById(int id) {
        for (Book book : books) {
            if (book.getId() == id) {
                return book;
            }
        }
        return null;
    }

    public Book searchByISBN(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equalsIgnoreCase(isbn)) {
                return book;
            }
        }
        return null;
    }

    public Book searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        return null;
    }
    
    public Book searchByPublishedYear(int publishedYear) {
        for (Book book : books) {
            if (book.getPublishedYear() == publishedYear) {
                return book;
            }
        }
        return null;
    }
    
    public void listAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
            return;
        }

        System.out.println("\n=== All Books ===");
        for (Book book : books) {
            System.out.println(book); // This will call toString()
        }
    }
    
    private void displayBook(Book book) {
        System.out.println("ID: " + book.getId());
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("ISBN: " + book.getIsbn());
        System.out.println("Published Year: " + book.getPublishedYear());
        System.out.println("Category: " + book.getCategory());
        System.out.println("Available: " + (book.isIsAvailable() ? "Yes" : "No"));
        System.out.println("----------------------------------------");
    }
}

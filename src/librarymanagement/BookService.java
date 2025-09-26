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
        System.out.println("\n=== Add New Book ===");

        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        
        System.out.print("Enter title: ");
        String title = sc.nextLine();

        System.out.print("Enter author: ");
        String author = sc.nextLine();

        System.out.print("Enter ISBN: ");
        String isbn = sc.nextLine();

        System.out.print("Enter published year: ");
        int publishedYear = sc.nextInt();
        sc.nextLine();
        
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

        int id = sc.nextInt();
        sc.nextLine();

        Book bookToRemove = searchById(id);

        if (bookToRemove == null) {
            System.out.println("No book found with ID: " + id);
            return;
        }

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
    
    public Book searchByCategory(String category) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(category)) {
                return book;
            }
        }
        return null;
    }
    
    public void removeBookById(Scanner sc) {
        System.out.print("Enter book ID: ");
        int id = sc.nextInt();
        sc.nextLine(); // Clear buffer

        boolean foundById = false;
        for (int i = 0; i < books.size(); i++) {
            if (books.get(i).getId() == id) {
                books.remove(i);
                foundById = true;
                System.out.println("Book with ID " + id + " removed successfully!");
                break;
            }
        }
        if (!foundById) {
            System.out.println("No book found with ID: " + id);
        }
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

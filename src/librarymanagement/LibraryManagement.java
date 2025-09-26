/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarymanagement;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author madvillain
 */
    class Book {
        private int id, publishedYear;
        private String isbn, title, author, category;
        private boolean isAvailable;

        public Book(int id, int publishedYear, String isbn, String title, String author, String category, boolean isAvailable) {
            this.id = id;
            this.publishedYear = publishedYear;
            this.isbn = isbn;
            this.title = title;
            this.author = author;
            this.category = category;
            this.isAvailable = isAvailable;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPublishedYear() {
            return publishedYear;
        }

        public void setPublishedYear(int publishedYear) {
            this.publishedYear = publishedYear;
        }

        public String getIsbn() {
            return isbn;
        }

        public void setIsbn(String isbn) {
            this.isbn = isbn;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public boolean isIsAvailable() {
            return isAvailable;
        }

        public void setIsAvailable(boolean isAvailable) {
            this.isAvailable = isAvailable;
        }

        @Override
        public String toString() {
            return String.format("ID: %d | Title: %s | Author: %s | ISBN: %s | Year: %d | Category: %s | Available: %s",
                    id, title, author, isbn, publishedYear, category, isAvailable ? "Yes" : "No");
        }
    }

    ///// UI
    
    public class LibraryManagement {

        private static final Scanner sc = new Scanner(System.in);
        private static final BookService bookService = new BookService();

        public static void displayMenu() {
            System.out.println("\n=== Library Management System ===");
            System.out.println("1. Book Management");
            System.out.println("2. List all books");
            System.out.println("3. Search books");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
        }

        public static void displayBookMenu() {
            System.out.println("\n=== Book Management ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("9. Back to Main Menu");
            System.out.print("Enter choice: ");
        }

        private static void bookManagement() {
            boolean backToMain = false;
            while (!backToMain) {
                displayBookMenu();
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        bookService.addBook(sc);
                        break;
                    case 2:
                        bookService.removeBook(sc);
                        break;
                    case 9:
                        backToMain = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }

        private static void bookSearch() {
            System.out.println("\n=== Search Books ===");
            System.out.println("1. Search by ID");
            System.out.println("2. Search by Title"); 
            System.out.println("3. Search by ISBN");
            System.out.println("4. Search by Publish Year");
            System.out.println("5. Search by Category");
            System.out.print("Enter choice: ");

            int searchChoice = sc.nextInt();
            sc.nextLine();

            switch (searchChoice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = sc.nextInt();
                    bookService.searchById(id);
                    break;
                case 2:
                    System.out.print("Enter title: ");
                    String title = sc.nextLine();
                    bookService.searchByTitle(title);
                    break;
                case 3:
                    System.out.print("Enter ISBN: ");
                    String isbn = sc.nextLine();
                    bookService.searchByISBN(isbn);
                    break;
                case 4:
                    System.out.print("Enter publish year: ");
                    int year = sc.nextInt();
                    bookService.searchByPublishedYear(year);
                    break;
                case 5:
                    System.out.print("Enter category: ");
                    String category = sc.nextLine();
                    bookService.searchByCategory(category);
                    break;
                default:
                    System.out.println("Invalid search option.");
            }
        }

        public static void main(String[] args) {
            boolean exit = false;
            while (!exit) {
                displayMenu();
                int choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        bookManagement();
                        break;
                    case 2:
                        bookService.listAllBooks();
                        break;
                    case 3:
                        bookSearch();
                        break;
                    case 0:
                        exit = true;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
    }

    ///// xu ly du lieu

    class BookService {
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
                System.out.println("No book found.");
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

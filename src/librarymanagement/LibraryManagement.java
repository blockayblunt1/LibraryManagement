/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarymanagement;

import java.util.Scanner;

/**
 *
 * @author madvillain
 */
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
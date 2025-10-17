/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package librarymanagement;

import java.util.Scanner;
import static librarymanagement.BookService.readInt;

/**
 *
 * @author madvillain
 */

    public class LibraryManagement {
        private static final Scanner sc = new Scanner(System.in);
        private static final BookService bookService = new BookService();
        private static final LibrarianService librarianService = new LibrarianService();
        private static final ReaderService readerService = new ReaderService();

        public static void main(String[] args) {
            boolean exit = false;
            while (!exit) {
                displayMainMenu();
                int choice = readInt(sc);

                switch (choice) {
                    case 1:
                        librarianMenu();
                        break;
                    case 2:
                        readerMenu();
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
        
        private static void librarianMenu() {
            boolean backToMain = false;
            while (!backToMain) {
                displayLibrarianMenu();
                int choice = readInt(sc);

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
                    case 4:
                        readerManagement();
                        break;
                    case 5:
                        librarianManagement();
                        break;
                    case 9:
                        backToMain = true;
                        break;
                    case 0:
                        backToMain = true;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }

        private static void readerMenu() {
            boolean backToMain = false;
            while (!backToMain) {
                displayReaderMenu();
                int choice = readInt(sc);

                switch (choice) {
                    case 1:
                        bookService.listAllBooks();
                        break;
                    case 2:
                        bookSearch();
                        break;
                    case 9:
                        backToMain = true;
                        break;
                    case 0:
                        backToMain = true;
                        System.out.println("Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            }
        }
        
        public static void displayMainMenu() {
            System.out.println("\n=== Library ===");
            System.out.println("1. Librarian");
            System.out.println("2. Reader");
            System.out.println("0. Exit.");
            System.out.print("Enter choice: ");
        }

        public static void displayLibrarianMenu() {
            System.out.println("\n=== Librarian Menu ===");
            System.out.println("1. Book Management.");
            System.out.println("2. List all books.");
            System.out.println("3. Search books.");
            System.out.println("4. Reader Management.");
            System.out.println("5. Librarian Management.");
            System.out.println("9. Back");
            System.out.println("0. Exit.");
            System.out.print("Enter choice: ");
        }

        public static void displayReaderMenu() {
            System.out.println("\n=== Reader Menu ===");
            System.out.println("1. List all books.");
            System.out.println("2. Search books.");
            System.out.println("9. Back");
            System.out.println("0. Exit.");
            System.out.print("Enter choice: ");
        }

        public static void displayBookMenu() {
            System.out.println("\n=== Book Management ===");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("9. Back");
            System.out.print("Enter choice: ");
        }

        private static void bookManagement() {
            boolean backToMain = false;
            while (!backToMain) {
                displayBookMenu();
                int choice = readInt(sc);

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

            int searchChoice = readInt(sc);
            sc.nextLine();

            switch (searchChoice) {
                case 1:
                    System.out.print("Enter ID: ");
                    int id = readInt(sc);
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
                    int year = readInt(sc);
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
        
        private static void readerManagement() {
            boolean backToMain = false;
            while (!backToMain) {
                displayReaderManagementMenu();
                int choice = readInt(sc);

                switch (choice) {
                    case 1:
                        readerService.addReader(sc);
                        break;
                    case 2:
                        readerService.listAllReaders();
                        break;
                    case 3:
                        readerService.searchReaderById(sc);
                        break;
                    case 4:
                        readerService.searchReaderByName(sc);
                        break;
                    case 5:
                        readerService.updateReader(sc);
                        break;
                    case 6:
                        readerService.removeReader(sc);
                        break;
                    case 9:
                        backToMain = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
        
        private static void librarianManagement() {
            boolean backToMain = false;
            while (!backToMain) {
                displayLibrarianManagementMenu();
                int choice = readInt(sc);

                switch (choice) {
                    case 1:
                        librarianService.addLibrarian(sc);
                        break;
                    case 2:
                        librarianService.removeLibrarian(sc);
                        break;
                    case 3:
                        librarianService.listAllLibrarians();
                        break;
                    case 9:
                        backToMain = true;
                        break;
                    default:
                        System.out.println("Invalid choice.");
                }
            }
        }
        
        public static void displayReaderManagementMenu() {
            System.out.println("\n=== Reader Management ===");
            System.out.println("1. Add Reader");
            System.out.println("2. List All Readers");
            System.out.println("3. Search Reader by ID");
            System.out.println("4. Search Reader by Name");
            System.out.println("5. Update Reader");
            System.out.println("6. Remove Reader");
            System.out.println("9. Back");
            System.out.print("Enter choice: ");
        }
        
        public static void displayLibrarianManagementMenu() {
            System.out.println("\n=== Librarian Management ===");
            System.out.println("1. Add Librarian");
            System.out.println("2. Remove Librarian");
            System.out.println("3. List All Librarians");
            System.out.println("9. Back");
            System.out.print("Enter choice: ");
        }
    }


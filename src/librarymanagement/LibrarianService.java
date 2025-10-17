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
public class LibrarianService {
    private List<Librarian> librarians = new ArrayList<>();
    
    public void addLibrarian(Scanner sc) {
        System.out.println("\n=== Add New Librarian ===");
        
        System.out.print("Enter librarian ID: ");
        int id = BookService.readInt(sc);
        sc.nextLine();
        
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        
        System.out.print("Enter employee number: ");
        String employeeNumber = sc.nextLine();
        
        Librarian librarian = new Librarian(id, name, email, employeeNumber);
        librarians.add(librarian);
        System.out.println("Librarian added successfully!");
    }
    
    public void removeLibrarian(Scanner sc) {
        if (librarians.isEmpty()) {
            System.out.println("No librarians available to remove.");
            return;
        }
        
        System.out.println("\n=== Remove Librarian ===");
        System.out.print("Enter Librarian ID to remove: ");
        int id = BookService.readInt(sc);
        
        Librarian librarianToRemove = findLibrarianById(id);
        
        if (librarianToRemove == null) {
            System.out.println("Librarian not found.");
            return;
        }
        
        librarians.remove(librarianToRemove);
        System.out.println("Librarian removed successfully!");
    }
    
    public Librarian findLibrarianById(int id) {
        for (Librarian librarian : librarians) {
            if (librarian.getLibrarianId() == id) {
                return librarian;
            }
        }
        return null;
    }
    
    public void listAllLibrarians() {
        if (librarians.isEmpty()) {
            System.out.println("No librarians in the system.");
            return;
        }
        
        System.out.println("\n=== All Librarians ===");
        for (Librarian librarian : librarians) {
            System.out.println("ID: " + librarian.getLibrarianId() + ", Name: " + librarian.getName() + ", Email: " + librarian.getEmail() + ", Employee #: " + librarian.getEmployeeNumber());
        }
    }
    
    public boolean authenticateLibrarian(int librarianId) {
        return findLibrarianById(librarianId) != null;
    }
}

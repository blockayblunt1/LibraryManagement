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
public class ReaderService {
    private List<Reader> readers = new ArrayList<>();
    
    public void addReader(Scanner sc) {
        System.out.println("\n=== Add New Reader ===");
        
        System.out.print("Enter reader ID: ");
        int id = BookService.readInt(sc);
        sc.nextLine();
        
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        
        Reader reader = new Reader(id, name, email, phoneNumber, address);
        readers.add(reader);
        System.out.println("Reader added successfully!");
    }
    
    public void removeReader(Scanner sc) {
        if (readers.isEmpty()) {
            System.out.println("No readers available to remove.");
            return;
        }
        
        System.out.println("\n=== Remove Reader ===");
        System.out.print("Enter Reader ID to remove: ");
        int id = BookService.readInt(sc);
        
        Reader readerToRemove = findReaderById(id);
        
        if (readerToRemove == null) {
            System.out.println("Reader not found!");
            return;
        }
        
        System.out.println("Reader to remove: " + readerToRemove);
        System.out.print("Are you sure? (y/n): ");
        sc.nextLine();
        String confirm = sc.nextLine();
        
        if (confirm.toLowerCase().equals("y") || confirm.toLowerCase().equals("yes")) {
            readers.remove(readerToRemove);
            System.out.println("Reader removed successfully!");
        } else {
            System.out.println("Remove operation cancelled.");
        }
    }
    
    public void listAllReaders() {
        if (readers.isEmpty()) {
            System.out.println("No readers in the system.");
            return;
        }
        
        System.out.println("\n=== All Readers ===");
        for (Reader reader : readers) {
            System.out.println(reader);
        }
    }
    
    public Reader findReaderById(int id) {
        for (Reader reader : readers) {
            if (reader.getReaderId() == id) {
                return reader;
            }
        }
        return null;
    }
    
    public void searchReaderById(Scanner sc) {
        System.out.print("Enter Reader ID to search: ");
        int id = BookService.readInt(sc);
        
        Reader reader = findReaderById(id);
        if (reader != null) {
            System.out.println("\n=== Reader Found ===");
            System.out.println(reader);
        } else {
            System.out.println("Reader not found!");
        }
    }
    
    public void searchReaderByName(Scanner sc) {
        System.out.print("Enter reader name to search: ");
        sc.nextLine();
        String searchName = sc.nextLine();
        
        System.out.println("\n=== Search Results ===");
        boolean found = false;
        
        for (Reader reader : readers) {
            if (reader.getName().toLowerCase().contains(searchName.toLowerCase())) {
                System.out.println(reader);
                found = true;
            }
        }
        
        if (!found) {
            System.out.println("No readers found with name containing: " + searchName);
        }
    }
    
    public void updateReader(Scanner sc) {
        System.out.print("Enter Reader ID to update: ");
        int id = BookService.readInt(sc);
        
        Reader reader = findReaderById(id);
        if (reader == null) {
            System.out.println("Reader not found!");
            return;
        }
        
        System.out.println("\n=== Update Reader ===");
        System.out.println("Current info: " + reader);
        
        sc.nextLine();
        
        System.out.print("Enter new name (current: " + reader.getName() + "): ");
        String name = sc.nextLine();
        if (!name.trim().isEmpty()) {
            reader.setName(name);
        }
        
        System.out.print("Enter new email (current: " + reader.getEmail() + "): ");
        String email = sc.nextLine();
        if (!email.trim().isEmpty()) {
            reader.setEmail(email);
        }
        
        System.out.print("Enter new phone number (current: " + reader.getPhoneNumber() + "): ");
        String phoneNumber = sc.nextLine();
        if (!phoneNumber.trim().isEmpty()) {
            reader.setPhoneNumber(phoneNumber);
        }
        
        System.out.print("Enter new address (current: " + reader.getAddress() + "): ");
        String address = sc.nextLine();
        if (!address.trim().isEmpty()) {
            reader.setAddress(address);
        }
        
        System.out.println("Reader updated successfully!");
        System.out.println("Updated info: " + reader);
    }
}
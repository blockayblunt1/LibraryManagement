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
            System.out.println("Reader not found.");
            return;
        }
        
        readers.remove(readerToRemove);
        System.out.println("Reader removed successfully!");
    }
    
    public Reader findReaderById(int id) {
        for (Reader reader : readers) {
            if (reader.getReaderId() == id) {
                return reader;
            }
        }
        return null;
    }
    
    public void listAllReaders() {
        if (readers.isEmpty()) {
            System.out.println("No readers in the system.");
            return;
        }
        
        System.out.println("\n=== All Readers ===");
        for (Reader reader : readers) {
            System.out.println("ID: " + reader.getReaderId() + ", Name: " + reader.getName() + ", Email: " + reader.getEmail() + ", Phone: " + reader.getPhoneNumber() + ", Address: " + reader.getAddress());
        }
    }
    
    public boolean authenticateReader(int readerId) {
        return findReaderById(readerId) != null;
    }
    
    public void updateReader(Scanner sc) {
        if (readers.isEmpty()) {
            System.out.println("No readers available to update.");
            return;
        }
        
        System.out.println("\n=== Update Reader ===");
        System.out.print("Enter Reader ID to update: ");
        int id = BookService.readInt(sc);
        sc.nextLine();
        
        Reader reader = findReaderById(id);
        
        if (reader == null) {
            System.out.println("Reader not found.");
            return;
        }
        
        System.out.println("Current details: " + reader);
        System.out.println("\nEnter new details (press Enter to keep current value):");
        
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        if (!name.trim().isEmpty()) {
            reader.setName(name);
        }
        
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        if (!email.trim().isEmpty()) {
            reader.setEmail(email);
        }
        
        System.out.print("Enter phone number: ");
        String phoneNumber = sc.nextLine();
        if (!phoneNumber.trim().isEmpty()) {
            reader.setPhoneNumber(phoneNumber);
        }
        
        System.out.print("Enter address: ");
        String address = sc.nextLine();
        if (!address.trim().isEmpty()) {
            reader.setAddress(address);
        }
        
        System.out.println("Reader updated successfully!");
    }
    
    public List<Reader> getAllReaders() {
        return new ArrayList<>(readers);
    }
    
    public void searchReaderById(Scanner sc) {
        System.out.print("Enter Reader ID: ");
        int id = BookService.readInt(sc);
        Reader reader = findReaderById(id);
        if (reader != null) {
            System.out.println(reader);
        } else {
            System.out.println("Reader not found.");
        }
    }
    
    public void searchReaderByName(Scanner sc) {
        System.out.print("Enter Reader Name: ");
        sc.nextLine();
        String name = sc.nextLine();
        boolean found = false;
        for (Reader r : readers) {
            if (r.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(r);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No readers found with that name.");
        }
    }
}

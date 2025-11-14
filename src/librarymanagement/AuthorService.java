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
public class AuthorService {
    private List<Author> authors = new ArrayList<>();
    
    public void addAuthor(Scanner sc) {
        System.out.println("\n=== Add New Author ===");
        
        System.out.print("Enter author ID: ");
        int id = BookService.readInt(sc);
        sc.nextLine();
        
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        
        System.out.print("Enter nationality: ");
        String nationality = sc.nextLine();
        
        System.out.print("Enter birth year: ");
        int birthYear = BookService.readInt(sc);
        sc.nextLine();
        
        Author author = new Author(id, name, nationality, birthYear);
        authors.add(author);
        System.out.println("Author added successfully!");
    }
    
    public void removeAuthor(Scanner sc) {
        if (authors.isEmpty()) {
            System.out.println("No authors available to remove.");
            return;
        }
        
        System.out.println("\n=== Remove Author ===");
        System.out.print("Enter Author ID to remove: ");
        int id = BookService.readInt(sc);
        
        Author authorToRemove = findAuthorById(id);
        
        if (authorToRemove == null) {
            System.out.println("Author not found.");
            return;
        }
        
        authors.remove(authorToRemove);
        System.out.println("Author removed successfully!");
    }
    
    public Author findAuthorById(int id) {
        for (Author author : authors) {
            if (author.getAuthorId() == id) {
                return author;
            }
        }
        return null;
    }
    
    public void listAllAuthors() {
        if (authors.isEmpty()) {
            System.out.println("No authors in the system.");
            return;
        }
        
        System.out.println("\n=== All Authors ===");
        for (Author author : authors) {
            System.out.println(author);
        }
    }
    
    public void searchAuthorById(Scanner sc) {
        System.out.print("Enter Author ID: ");
        int id = BookService.readInt(sc);
        Author author = findAuthorById(id);
        if (author != null) {
            System.out.println(author);
        } else {
            System.out.println("Author not found.");
        }
    }
    
    public void searchAuthorByName(Scanner sc) {
        System.out.print("Enter Author Name: ");
        sc.nextLine();
        String name = sc.nextLine();
        boolean found = false;
        for (Author a : authors) {
            if (a.getName().toLowerCase().contains(name.toLowerCase())) {
                System.out.println(a);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No authors found with that name.");
        }
    }
    
    public void updateAuthor(Scanner sc) {
        if (authors.isEmpty()) {
            System.out.println("No authors available to update.");
            return;
        }
        
        System.out.println("\n=== Update Author ===");
        System.out.print("Enter Author ID to update: ");
        int id = BookService.readInt(sc);
        sc.nextLine();
        
        Author author = findAuthorById(id);
        
        if (author == null) {
            System.out.println("Author not found.");
            return;
        }
        
        System.out.println("Current details: " + author);
        System.out.println("\nEnter new details (press Enter to keep current value):");
        
        System.out.print("Enter name [" + author.getName() + "]: ");
        String name = sc.nextLine();
        if (!name.trim().isEmpty()) {
            author.setName(name);
        }
        
        System.out.print("Enter nationality [" + author.getNationality() + "]: ");
        String nationality = sc.nextLine();
        if (!nationality.trim().isEmpty()) {
            author.setNationality(nationality);
        }
        
        System.out.print("Enter birth year [" + author.getBirthYear() + "]: ");
        String birthYearStr = sc.nextLine();
        if (!birthYearStr.trim().isEmpty()) {
            try {
                int birthYear = Integer.parseInt(birthYearStr);
                author.setBirthYear(birthYear);
            } catch (NumberFormatException e) {
                System.out.println("Invalid year format. Keeping current value.");
            }
        }
        
        System.out.println("Author updated successfully!");
    }
    
    public List<Author> getAllAuthors() {
        return new ArrayList<>(authors);
    }
}

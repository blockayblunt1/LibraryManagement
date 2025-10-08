package librarymanagement;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author madvillain
 */
public class Book {
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

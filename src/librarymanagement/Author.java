/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement;

/**
 *
 * @author madvillain
 */
public class Author extends User {
    private String nationality;
    private int birthYear;

    public Author(int authorId, String name, String email, String nationality, int birthYear) {
        super(authorId, name, email);
        this.nationality = nationality;
        this.birthYear = birthYear;
    }

    public int getAuthorId() {
        return this.getUserId();
    }

    public void setAuthorId(int authorId) {
        this.setUserId(authorId);
    }

    public String getNationality() {
        return this.nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public int getBirthYear() {
        return this.birthYear;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    @Override
    public String toString() {
        return "Author{" + "authorId=" + this.getUserId() + ", name=" + this.getName() + ", email=" + this.getEmail() + ", nationality=" + this.nationality + ", birthYear=" + this.birthYear + '}';
    }
}

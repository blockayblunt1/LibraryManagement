/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement;

/**
 *
 * @author madvillain
 */
public class Author {
    private int authorId;
    private String name;
    private String nationality;
    private int birthYear;

    public Author(int authorId, String name, String nationality, int birthYear) {
        this.authorId = authorId;
        this.name = name;
        this.nationality = nationality;
        this.birthYear = birthYear;
    }

    public int getAuthorId() {
        return this.authorId;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
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
        return "Author{" + "authorId=" + this.authorId + ", name=" + this.name + ", nationality=" + this.nationality + ", birthYear=" + this.birthYear + '}';
    }
}

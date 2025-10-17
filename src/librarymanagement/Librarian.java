/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement;

/**
 *
 * @author madvillain
 */
public class Librarian extends User {
    private String employeeNumber;

    public Librarian(int userId, String name, String email, String employeeNumber) {
        super(userId, name, email);
        this.employeeNumber = employeeNumber;
    }

    public int getLibrarianId() {
        return this.getUserId();
    }

    public void setLibrarianId(int librarianId) {
        setUserId(librarianId);
    }

    public String getEmployeeNumber() {
        return this.employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    @Override
    public String toString() {
        return "Librarian{" + "librarianId=" + this.getUserId() + ", name=" + this.getName() +  ", email=" + this.getEmail() + ", employeeNumber=" + this.employeeNumber + '}';
    }
    
    
}

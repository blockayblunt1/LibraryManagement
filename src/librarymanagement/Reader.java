/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package librarymanagement;

/**
 *
 * @author madvillain
 */
public class Reader extends User {
    private String phoneNumber;
    private String address;

    public Reader(int userId, String name, String email, String phoneNumber, String address) {
        super(userId, name, email);
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getReaderId() {
        return this.getUserId();
    }

    public void setReaderId(int readerId) {
        this.setUserId(readerId);
    }

    @Override
    public String toString() {
        return "Reader{" + "readerId=" + this.getUserId() + ", name=" + this.getName() + ", email=" + this.getEmail() + ", phoneNumber=" + this.phoneNumber + ", address=" + this.address + '}';
    }
}

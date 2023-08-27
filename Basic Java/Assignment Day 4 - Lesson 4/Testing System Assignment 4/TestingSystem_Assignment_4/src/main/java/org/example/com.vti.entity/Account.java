package org.example.com.vti.entity;

import org.example.com.vti.entity.Position.Position;

import java.util.Date;

public class Account {
    private short accountID;
    private String email;
    private String username;
    private String fullName;
    private Department department;
    private Position position;
    private Date createDate;

    /*
    * Question 2:
        Tạo constructor cho Account:
        a) Không có parameters
        b) Có các parameter là id, Email, Username, FirstName,
        LastName (với FullName = FirstName + LastName)
        c) Có các parameter là id, Email, Username, FirstName,
        LastName (với FullName = FirstName + LastName) và
        Position của User, default createDate = now
        d) Có các parameter là id, Email, Username, FirstName,
        LastName (với FullName = FirstName + LastName) và
        Position của User, createDate
        Khởi tạo 1 Object với mỗi constructor ở trên*/
    public Account() {}
    public Account(short accountID, String email, String username, String firstName, String lastName) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName;
    }

    public Account(short accountID, String email, String username, String firstName, String lastName, Position position) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName;
        this.position = position;
        this.createDate = new Date();
    }

    public Account(short accountID, String email, String username, String firstName, String lastName, Position position, Date newDate) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.fullName = firstName + " " + lastName;
        this.position = position;
        this.createDate = newDate;
    }

    // Getter methods
    public short getAccountID() {
        return accountID;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getFullName() {
        return fullName;
    }

    public Department getDepartment() {
        return department;
    }

    public Position getPosition() {
        return position;
    }

    public Date getCreateDate() {
        return createDate;
    }

    // Setter methods
    public void setAccountID(short accountID) {
        this.accountID = accountID;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public void displayIn4(){
        System.out.println("_______Account information______");
        System.out.println("Đây là tài khoản thứ: " + this.accountID);
        System.out.println("Email: " + this.email);
        System.out.println("Ten đăng nhập: " + this.username);
        System.out.println("Fullname: " + this.fullName);
        System.out.println("Phòng ban: " + this.department);
        System.out.println("Vị trí: " + this.position);
        System.out.println("Ngày tạo: " + this.createDate);
    }

    public void displayIn4_table(){
        System.out.printf("| %d |%-20s|%-15s|%-15s| %d | %d | %s |%n" ,this.accountID, this.email, this.username, this.fullName, this.department, this.position, this.createDate);
    }

}

package org.example.classes;

import java.util.Date;

public class Account {
    public short accountID;
    public String email;
    public String username;
    public String fullName;
    public byte departmentID;
    public byte positionID;
    public Date createDate;

    public Account(short accountID, String email, String username, String fullName, byte departmentID, byte positionID, Date createDate) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.departmentID = departmentID;
        this.positionID = positionID;
        this.createDate = createDate;
    }


    public void displayIn4(){
        System.out.println("_______Account information______");
        System.out.println("Đây là tài khoản thứ: " + this.accountID);
        System.out.println("Email: " + this.email);
        System.out.println("Ten đăng nhập: " + this.username);
        System.out.println("Fullname: " + this.fullName);
        System.out.println("Phòng ban: " + this.departmentID);
        System.out.println("Vị trí: " + this.positionID);
        System.out.println("Ngày tạo: " + this.createDate);
    }

    public void displayIn4_table(){
        System.out.printf("| %d |%-20s|%-15s|%-15s| %d | %d | %s |%n" ,this.accountID, this.email, this.username, this.fullName, this.departmentID, this.positionID, this.createDate);
    }

}

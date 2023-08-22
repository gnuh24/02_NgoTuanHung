package org.example.classes;

public class Department {
    public byte departmentID;
    public String departmentName;

    public Department(byte departmentID, String departmentName) {
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }
    public void displayIn4(){
        System.out.println("_______Department information______");
        System.out.println("ID: " + this.departmentID);
        System.out.println("Name: " + this.departmentName);
    }
}
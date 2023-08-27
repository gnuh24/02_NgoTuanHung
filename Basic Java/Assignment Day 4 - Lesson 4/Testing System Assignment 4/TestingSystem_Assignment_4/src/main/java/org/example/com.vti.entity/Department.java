package org.example.com.vti.entity;
import org.example.com.vti.entity.Position.EnumPositionName;
public class Department {
    private byte departmentID;
    private EnumPositionName departmentName;

    public byte getDepartmentID() {
        return departmentID;
    }

    public void setDepartmentID(byte departmentID) {
        this.departmentID = departmentID;
    }

    public EnumPositionName getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(EnumPositionName departmentName) {
        this.departmentName = departmentName;
    }
    /*Question 1:
        Tạo constructor cho department:
        a) không có parameters
        b) Có 1 parameter là nameDepartment và default id của
        Department = 0
        Khởi tạo 1 Object với mỗi constructor ở trên*/
    public Department() {
    }

    public Department(EnumPositionName departmentName) {
        this.departmentID = 0;
        this.departmentName = departmentName;
    }


    public void displayIn4(){
        System.out.println("_______Department information______");
        System.out.println("ID: " + this.departmentID);
        System.out.println("Name: " + this.departmentName);
    }
}
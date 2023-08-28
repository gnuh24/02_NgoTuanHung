package org.example.com.vti.entity;

public class Employee extends CanBo{
    private String work;
    public Employee(String name, int age, enumGender gender, String address, String work) {
        super(name, age, gender, address);
        this.work = work;
    }
}

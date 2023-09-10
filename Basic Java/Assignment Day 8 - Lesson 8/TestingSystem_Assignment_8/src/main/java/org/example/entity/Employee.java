package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Employee<E>{
    private int id;
    private String name;
    E [] salaries ;
    public <T> T finalSalary(){
        return (T) this.salaries[11];
    }

    // Constructor
    public Employee(int id, String name, E[] salaries) {
        this.id = id;
        this.name = name;
        this.salaries = salaries;
    }

    // Getter cho thuộc tính id
    public int getId() {
        return id;
    }

    // Setter cho thuộc tính id
    public void setId(int id) {
        this.id = id;
    }

    // Getter cho thuộc tính name
    public String getName() {
        return name;
    }

    // Setter cho thuộc tính name
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        ArrayList<E> salary = new ArrayList<>(List.of(this.salaries));
        return "ID: " + this.id + "\n" + "Name: " + this.name + "\n" + "Salary: " + salary;
     }
}


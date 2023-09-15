package org.example.entity;

public class Department {
    private int id;
    private String name;

    // Constructor mặc định không tham số
    public Department() {
    }

    // Constructor với tham số
    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter cho id
    public int getId() {
        return id;
    }

    // Setter cho id
    public void setId(int id) {
        this.id = id;
    }

    // Getter cho name
    public String getName() {
        return name;
    }

    // Setter cho name
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}


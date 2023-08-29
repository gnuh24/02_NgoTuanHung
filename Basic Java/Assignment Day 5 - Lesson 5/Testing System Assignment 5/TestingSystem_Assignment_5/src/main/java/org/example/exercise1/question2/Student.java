package org.example.exercise1.question2;

public class Student {
    private int id;
    private String fullName;
    private String address;
    private int priority;

    public Student(int id, String name, String address, int priority){
        this.id = id;
        this.fullName = name;
        this.address = address;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    // Getter and Setter for 'fullName'
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    // Getter and Setter for 'address'
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Getter and Setter for 'priority'
    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}

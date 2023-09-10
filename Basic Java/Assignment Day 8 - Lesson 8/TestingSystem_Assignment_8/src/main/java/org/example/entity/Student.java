package org.example.entity;

public class Student {
    private int id;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Student(int id, String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString(){
        return  "(" + this.id + " " + this.name + ")";
    }

}

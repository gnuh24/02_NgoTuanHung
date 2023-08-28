package org.example.com.vti.entity;

public abstract class NewStudent extends Person {
    private int id;
    public NewStudent(int id, String name){
        super(name);
        this.id = id;
    }
}

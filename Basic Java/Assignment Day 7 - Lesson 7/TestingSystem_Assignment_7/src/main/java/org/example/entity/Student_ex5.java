package org.example.entity;

import java.io.Serializable;

public class Student_ex5 implements Serializable {
    private String name;
    private int id;

    public Student_ex5(String name, int id){
        this.name = name;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString(){
        return "[ " + this.name + " - " + this.id + " ]";
    }
}

package org.example.entity;

public class newStudent {
    private String name;
    private final int id;

    public newStudent(String name, int id){
        this.name = name;
        this.id = id;
    }

    public final void study(){
        System.out.println("Đang học Javalorant ^^");
    }

}

package org.example.com.vti.entity;

public class Worker extends CanBo{
    private int level;
    public Worker(String name, int age, enumGender gender, String address, int level){
        super(name, age, gender, address );
        this.level = level;
    }
}

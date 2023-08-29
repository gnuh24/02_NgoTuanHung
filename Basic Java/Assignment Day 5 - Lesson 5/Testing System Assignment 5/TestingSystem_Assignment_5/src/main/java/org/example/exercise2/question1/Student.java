package org.example.exercise2.question1;

import org.example.exercise2.question1.IStudent;

public class Student implements IStudent {
    private int id;
    private String name;
    private int group;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    @Override
    public void rollCall() {
        System.out.println(this.name + " điểm danh !!!");
    }

    @Override
    public void learning() {
        System.out.println(this.name + " đang học bài !!!");

    }

    @Override
    public void cleaningUp() {
        System.out.println(this.name + " đang dọn vệ sinh !!!");
    }

    public Student(int id, String name, int group){
        this.id = id;
        this.name = name;
        this.group = group;
    }
}

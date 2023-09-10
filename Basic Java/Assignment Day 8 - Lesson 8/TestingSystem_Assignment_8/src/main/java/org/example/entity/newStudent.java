package org.example.entity;

public class newStudent extends Student{
    private String date;
    private double score;

    public newStudent(int id, String name, String date, double score) {
        super(id, name);
        this.date = date;
        this.score = score;
    }

    @Override
    public String toString(){
        return "(" + this.getId() + " - " + this.getName() + " - " + this.date + " - " + this.score + ")";
    }
}

package org.example.exercise1.question2;

import org.example.exercise1.question2.Student;

public class StudentA extends Student {
    private String subjects = "Toán Lý Hóa";

    public StudentA(int id, String name, String address, int priority){
        super(id, name, address, priority);
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getSubjects() {
        return subjects;
    }
}

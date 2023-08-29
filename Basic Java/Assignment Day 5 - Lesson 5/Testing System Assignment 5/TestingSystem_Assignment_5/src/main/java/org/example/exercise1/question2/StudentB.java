package org.example.exercise1.question2;

import org.example.exercise1.question2.Student;

public class StudentB  extends Student {
    private String subjects = "Toán Sinh Hóa";
    public StudentB(int id, String name, String address, int priority){
        super(id, name, address, priority);
    }

    public void setSubjects(String subjects) {
        this.subjects = subjects;
    }

    public String getSubjects() {
        return subjects;
    }
}

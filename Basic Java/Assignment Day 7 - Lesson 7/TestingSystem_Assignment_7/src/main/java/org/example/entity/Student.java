package org.example.entity;

public class Student {
    private String name;
    private static String college;
    private static int moneyGroup;
    private static int numberOfStudents;
    public Student(String name){
        this.name = name;
        Student.numberOfStudents++;
    }

    public static void setCollege(String college) {
        Student.college = college;
    }
    public String getCollege() {
        return college;
    }

    public String getName() {
        return name;
    }



    public void setName(String name) {
        this.name = name;
    }

    public static int getMoneyGroup() {
        return moneyGroup;
    }

    public static void setMoneyGroup(int moneyGroup) {
        Student.moneyGroup = moneyGroup;
    }

    public static int getNumberOfStudents() {
        return numberOfStudents;
    }
    public static void setNumberOfStudents(int numberOfStudents) {
        Student.numberOfStudents = numberOfStudents;
    }
}

package org.example.entity;

public class PrimaryStudent extends Student{
    private static int numberOfPrimaryStudent;
    public PrimaryStudent(String name) {
        super(name);
        PrimaryStudent.numberOfPrimaryStudent++;
    }

    public static int getNumberOfPrimaryStudent() {
        return numberOfPrimaryStudent;
    }

    public static void setNumberOfPrimaryStudent(int numberOfPrimaryStudent) {
        PrimaryStudent.numberOfPrimaryStudent = numberOfPrimaryStudent;
    }
}

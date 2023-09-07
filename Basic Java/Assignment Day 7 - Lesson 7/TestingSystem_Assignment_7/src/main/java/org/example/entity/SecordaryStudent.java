package org.example.entity;

public class SecordaryStudent extends Student{
    private static int numberOfSDS;

    public SecordaryStudent(String name) {
        super(name);
        numberOfSDS++;
    }

    public static int getNumberOfSDS() {
        return numberOfSDS;
    }

    public static void setNumberOfSDS(int numberOfSDS) {
        SecordaryStudent.numberOfSDS = numberOfSDS;
    }
}

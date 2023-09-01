package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Student[] students = new Student[10];

        students[0] = new Student("Student 1", "ID1", "Date1", 8.5, 5.5, 3.5, 1.5, 0.5);
        students[1] = new Student("Student 2", "ID2", "Date2", 9.0, 6.0, 4.0, 2.0, 1.0);
        students[2] = new Student("Student 3", "ID3", "Date3", 8.7, 5.7, 3.7, 1.7, 0.7);
        students[3] = new Student("Student 4", "ID4", "Date4", 6.0, 4.0, 2.0, 1.0, 0.0);
        students[4] = new Student("Student 5", "ID5", "Date5", 7.0, 5.0, 3.0, 1.0, 0.5);
        students[5] = new Student("Student 6", "ID6", "Date6", 5.5, 4.5, 3.5, 1.5, 0.5);
        students[6] = new Student("Student 7", "ID7", "Date7", 3.5, 2.5, 1.5, 0.5, 0.0);
        students[7] = new Student("Student 8", "ID8", "Date8", 7.5, 5.5, 3.5, 2.0, 1.0);
        students[8] = new Student("Student 9", "ID9", "Date9", 4.0, 3.0, 2.0, 1.0, 0.5);
        students[9] = new Student("Student 10", "ID10", "Date10", 2.0, 1.0, 1.0, 0.0, 0.0);

        System.out.printf("%-20s %-10s %-20s %-5s %-5s %-5s %-5s %-5s %-5s %n",
                "Name", "ID", "Date", "RA", "SD", "CP", "CUT", "FMT", "Avg");
        for (Student student : students) {
            student.display();
        }
    }
}
package org.example.backend;

import org.example.entity.Student;
import org.example.entity.Student_ex5;

import java.io.IOException;
import java.util.ArrayList;

public class Exercise5 {
    public static void question5() throws IOException, ClassNotFoundException {
        Student_ex5 student1 = new Student_ex5("NAme1", 1);
        Student_ex5 student2 = new Student_ex5("NAme2", 2);
        Student_ex5 student3 = new Student_ex5("NAme3", 3);
        ArrayList<Object> firstList = new ArrayList<>();
        IOManager.writeObject(student1, "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\02_NgoTuanHung\\Basic Java\\Assignment Day 7 - Lesson 7\\TestingSystem_Assignment_7\\src\\main\\java\\org\\example\\backend", "StudentInformation.ser");
        IOManager.writeObject(student2, "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\02_NgoTuanHung\\Basic Java\\Assignment Day 7 - Lesson 7\\TestingSystem_Assignment_7\\src\\main\\java\\org\\example\\backend", "StudentInformation.ser");
        IOManager.writeObject(student3, "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\02_NgoTuanHung\\Basic Java\\Assignment Day 7 - Lesson 7\\TestingSystem_Assignment_7\\src\\main\\java\\org\\example\\backend", "StudentInformation.ser");
        ArrayList<Object> listStudent = IOManager.readObject("C:\\Users\\Tuan Hung\\Desktop\\Exercise\\02_NgoTuanHung\\Basic Java\\Assignment Day 7 - Lesson 7\\TestingSystem_Assignment_7\\src\\main\\java\\org\\example\\backend\\StudentInformation.ser");
        System.out.println(listStudent);
    }
}

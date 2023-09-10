package org.example.frontend;

import org.example.backend.Exercise_3;
import org.example.backend.IOManager;
import org.example.entity.Student;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Program3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Student student1 = new Student("NTHUng");
        Student student2 = new Student("NHDung1");
        Student student3 = new Student("NHDung2");
        Student student4 = new Student("NHDung3");
        Student student5 = new Student("NHDung4");



        IOManager.writeObject(student1, "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\02_NgoTuanHung\\Basic Java\\Assignment Day 7 - Lesson 7\\TestingSystem_Assignment_7\\src\\main\\java\\org\\example\\frontend", "Student.ser");
        IOManager.writeObject(student2, "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\02_NgoTuanHung\\Basic Java\\Assignment Day 7 - Lesson 7\\TestingSystem_Assignment_7\\src\\main\\java\\org\\example\\frontend", "Student.ser");
        IOManager.writeObject(student3, "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\02_NgoTuanHung\\Basic Java\\Assignment Day 7 - Lesson 7\\TestingSystem_Assignment_7\\src\\main\\java\\org\\example\\frontend", "Student.ser");
        IOManager.writeObject(student4, "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\02_NgoTuanHung\\Basic Java\\Assignment Day 7 - Lesson 7\\TestingSystem_Assignment_7\\src\\main\\java\\org\\example\\frontend", "Student.ser");
        IOManager.writeObject(student5, "C:\\Users\\Tuan Hung\\Desktop\\Exercise\\02_NgoTuanHung\\Basic Java\\Assignment Day 7 - Lesson 7\\TestingSystem_Assignment_7\\src\\main\\java\\org\\example\\frontend", "Student.ser");

        System.out.println( IOManager.readObject("C:\\Users\\Tuan Hung\\Desktop\\Exercise\\02_NgoTuanHung\\Basic Java\\Assignment Day 7 - Lesson 7\\TestingSystem_Assignment_7\\src\\main\\java\\org\\example\\frontend\\Student.ser").size() );


    }

}

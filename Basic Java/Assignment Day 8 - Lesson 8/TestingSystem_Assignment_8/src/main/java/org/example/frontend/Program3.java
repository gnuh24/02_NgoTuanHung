package org.example.frontend;

import org.example.backend.Exercise_3;
import org.example.entity.Employee;
import org.example.entity.Phone;
import org.example.entity.Student;

public class Program3 {
    public static void main(String [] args) {
        Exercise_3.question1();

        Exercise_3 test = new Exercise_3();
        Student a = new Student(3, "Ngo");

        System.out.println(test.print(a) );
        System.out.println(test.print(4));
        System.out.println(test.print(4.0));

        Integer [] b = {9,5,3,12,19,45,785,12,20,30, 19,10};
        Float [] c = {9f,5f,3f,12f,19f,45f,785f,12f,20f,30f, 19f,10f};
        Long [] d = {9L,5L,3L};
        Double [] f = {9.0,5.0,3.0,12.0,19.0,45.0,785.0,12.0,20.0,30.0, 19.0,10.0};

        test.question4(b);
        test.question4(c);
        test.question4(d);
        test.question4(f);

        System.out.println( new Employee<>(1, "Ngo Tuan Hung", b) );
        System.out.println( new Employee<>(1, "Ngo Tuan Hung", c) );
        System.out.println( new Employee<>(1, "Ngo Tuan Hung", f) );


    }



}

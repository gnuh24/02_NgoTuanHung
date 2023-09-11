package org.example.frontend;

import org.example.backend.Exercise_1;
import org.example.entity.Student;

import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Program1 {
    public static void main(String [] args) {
        ArrayList<Student> students = Exercise_1.question1_createList();
        Exercise_1.question1_display(students);
        LinkedHashMap<Integer, String > students1 = Exercise_1.question6(students);
        System.out.println(students1);


        Exercise_1.question2();

        //Question3 tương tự question1 chỉ là thay lại thôi

        Exercise_1.question7(students1);
    }


}

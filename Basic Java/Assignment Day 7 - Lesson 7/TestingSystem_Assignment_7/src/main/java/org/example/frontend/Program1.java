package org.example.frontend;

import org.example.backend.Exercise_1;
import org.example.entity.Student;

public class Program1 {
    public static void main(String [] args){
        Exercise_1 ex1 = new Exercise_1();
        //ex1.question1();
        //ex1.question2();
        //ex1.question6();

        /*try {
            ex1.question7();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println(Student.getNumberOfStudents());
        }*/
        ex1.question8();
    }
}

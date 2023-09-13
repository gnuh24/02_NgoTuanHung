package org.example.backend;
import org.example.entity.Student;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Exercise_2 {
    public static void question1()  {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = null;
        try{
            date = dateFormat.parse("18/05/2020");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        System.out.println(date);
    }

    //@SuppressWarnings("deprecation")
    public static void question2(){
        Student newStudent = new Student(1, "Nguyễn Văn A");
        System.out.println(newStudent.getId());
        System.out.println(newStudent.newGetID());
    }
}

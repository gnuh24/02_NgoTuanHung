package org.example.exercise1.question2;

import org.example.exercise1.question2.*;

import java.util.ArrayList;

public class TuyenSinh implements ITuyenSinh {
    ArrayList<Student> listOfStudent = new ArrayList<>() ;

    @Override
    public void addNewStudent(Student newStudent){
        this.listOfStudent.add(newStudent);
    }

    @Override
    public void display(){
        for (Student i: this.listOfStudent){
            System.out.println("__________________________Thông tin thí sinh_________________________");
            System.out.println("ID: " + i.getId());
            System.out.println("Name: " + i.getFullName());
            System.out.println("Address: " + i.getAddress());
            System.out.println("Priority: " + i.getPriority());
            if (i instanceof StudentA)
                System.out.println("Khối A: " + ((StudentA) i).getSubjects());
            else if (i instanceof StudentB)
                System.out.println("Khối B: " + ((StudentB) i).getSubjects());
            else if (i instanceof StudentC)
                System.out.println("Khối C: " + ((StudentC) i).getSubjects() );

        }
    }

    @Override
    public void findAccountID(int id) {
        for (Student i: this.listOfStudent)
            if (i.getId() == id){
                System.out.println("__________________________Thông tin thí sinh_________________________");
                System.out.println("ID: " + i.getId());
                System.out.println("Name: " + i.getFullName());
                System.out.println("Address: " + i.getAddress());
                System.out.println("Priority: " + i.getPriority());
                if (i instanceof StudentA)
                    System.out.println("Khối A: " + ((StudentA) i).getSubjects());
                else if (i instanceof StudentB)
                    System.out.println("Khối B: " + ((StudentB) i).getSubjects());
                else if (i instanceof StudentC)
                    System.out.println("Khối C: " + ((StudentC) i).getSubjects() );
                break;
            }
    }

    public void exit(){
        System.exit(0);
    }
}

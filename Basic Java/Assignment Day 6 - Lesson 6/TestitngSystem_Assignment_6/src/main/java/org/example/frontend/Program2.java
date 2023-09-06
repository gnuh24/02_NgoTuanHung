package org.example.frontend;

import org.example.backend.Exercise2;
import org.example.entity.Account;
import org.example.entity.Department;
import org.example.entity.Group;

public class Program2 {
    public static void main(String [] agrs) {
        Exercise2 ex2 = new Exercise2();
        // ________________________Question 1 2_____________________________

        /*
        try {
            System.out.println(ex2.question1(7, 2));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            System.out.println("divide completed!");
        }*/

        // ________________________Question 3_____________________________

        /*
        try {
            ex2.question3();
        }
        catch (Exception e){
           e.printStackTrace();
            // System.out.println(e.getMessage());
        }*/


        // ________________________Question 4_____________________________

        /*int [] list = {1, 2, 3};
       try {
           System.out.println(ex2.getIndex(list, 3));
       }
       catch (Exception e) {
            e.printStackTrace();
       }*/

        // ________________________Question 5_____________________________
        // ________________________Question 6_____________________________

            System.out.println( ex2.inputAge0() );
        // ________________________Question 9_____________________________
        //Department department1 = new Department();
        // ________________________Question 10_____________________________
        //Group group1 = new Group();

        /*Account a = new Account();
        System.out.println(a.inputAge());*/


    }

}

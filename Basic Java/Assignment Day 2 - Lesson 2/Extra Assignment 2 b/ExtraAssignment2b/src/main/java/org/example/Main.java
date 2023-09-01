package org.example;
import org.example.listOfExercise.*;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("________________________________EX1________________________________________");
        Exercise_1 ex1 = new Exercise_1();
        ex1.question1(280f);
        ex1.question2(23300);
        ex1.quesiion3(12,200,485,1);
        ex1.question4(4, 5);
        ex1.question5(20, 5);
        ex1.question6(8.4f, 8.75f, 8.25f);

        System.out.println("__________________________EX2_____________________________________");
        Exercise2 ex2 = new Exercise2();
        ArrayList <Integer> listTest = new ArrayList<>();
        listTest.add(1);    listTest.add(1);
        listTest.add(2);
        listTest.add(3);    listTest.add(3);    listTest.add(3);
        listTest.add(4);    listTest.add(4);    listTest.add(5);
        listTest.add(8);    listTest.add(7);    listTest.add(5);

        System.out.println(listTest);

        System.out.println(ex2.question1(listTest, 1));
    }
}
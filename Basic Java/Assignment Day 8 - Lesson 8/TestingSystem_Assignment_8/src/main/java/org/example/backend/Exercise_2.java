package org.example.backend;

import org.example.entity.Student;
import org.example.entity.newStudent;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Exercise_2 {
    public static void quesiton1(){
        ArrayList<newStudent> testArrayList = new ArrayList<>();
        testArrayList.add (new newStudent(1, "Ngô Tuấn Hưng", "02-04-2004", 10));
        testArrayList.add (new newStudent(2, "Trần Xuân Trung", "02-07-2004", 8));
        testArrayList.add (new newStudent(3, "Ngô Xuân Trường", "12-04-2004", 5));

        System.out.println("Before sort: " + testArrayList);
        Collections.sort(testArrayList, new MyComparator());
        System.out.println("After sort: " + testArrayList);

    }
}

class MyComparator implements Comparator<newStudent>{
    @Override
    public int compare(newStudent a, newStudent b){
        if (a.getName().equals(b.getName()) ){
            if(a.getDate().equals(b.getDate())){
                if(a.getScore() > b.getScore()) return 1;
                else if (a.getScore() == b.getScore()) return 0;
                else return -1;
            }
            else return a.getDate().compareTo(b.getDate());
        }
        return a.getName().compareTo(b.getName());
    }
}
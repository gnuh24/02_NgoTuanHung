package org.example.listOfExercise;

import java.util.ArrayList;
import java.util.Collections;

public class Exercise2 {
    public ArrayList<Integer> question1(ArrayList<Integer> list, int n){
        ArrayList<Integer> result = new ArrayList<>();


        Collections.sort(list);
        int count = 1;
        for (int i=1; i < list.size(); i++){
            if (!list.get(i).equals(list.get(i - 1))){
                if (count == n)
                    result.add(list.get(i-1));
                count = 1;
            }
            else{
                count++;
            }
        }
        if (count == n)
            result.add(list.get(list.size() -1));

        return result;
    }



}

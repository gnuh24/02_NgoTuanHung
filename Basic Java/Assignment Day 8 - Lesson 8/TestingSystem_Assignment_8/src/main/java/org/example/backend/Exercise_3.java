package org.example.backend;

import org.example.entity.*;

public class Exercise_3 {
    public  static  void question1(){
        System.out.println(new EX3_Student(1, "Ngô Tuấn Hưng") );
        System.out.println(new EX3_Student(3.0, "Ngô Tuấn Hưng") );
        System.out.println(new EX3_Student("DKP1221", "Ngô Tuấn Hưng") );
    }

    public  <T>  T print(T input){
        return input;
    }

    public  <E>  void question4(E[] listInput){
        for (E i: listInput)
            System.out.print(i + " ");
        System.out.println();
    }

    public static void question6(){
        System.out.println("Đã tạo thành công!");
        System.out.println(new MyMap<>(3, "NGo Tuan Hung"));
    }

    public static void question7(){
        Phone<String, String> phone1 = new Phone<>("hungnt.020404@gmail.com", "3122560028");
        Phone<Integer, String> phone2 = new Phone<>(1, "3122560028");
        Phone<String, String> phone3 = new Phone<>("Ngô Tuấn Hưng", "3122560028");
    }
}

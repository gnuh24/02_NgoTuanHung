package org.example.backend;

import org.example.entity.MyMath;

import java.util.ArrayList;

public class Excercise_4 {
    public static void demo(){
        MyMath test = new MyMath();
        System.out.println(MyMath.question4_a(3, 5));
        System.out.println(MyMath.question4_b(3, 5.4, 9.5));
        System.out.println(MyMath.question4_c(3, 5, 15f, 20L));
        System.out.println(MyMath.question4_d(10f, 5L));
        System.out.println(MyMath.question4_e(2, 4f));
    }

    public static void question5(){
        ArrayList <Object> listWildcards = new ArrayList<>();
        listWildcards.add("Nguyễn Văn Nam");
        listWildcards.add("30 tuổi");
        listWildcards.add("Hà Đông, Hà Nội");
    }


}

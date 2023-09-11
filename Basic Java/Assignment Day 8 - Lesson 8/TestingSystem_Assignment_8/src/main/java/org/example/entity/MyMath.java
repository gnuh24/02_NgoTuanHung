package org.example.entity;

public class MyMath <T>{
    public static <E extends Number> double question4_a(E a, E b){
        return a.doubleValue() + b.doubleValue();
    }

    public static <E extends Number> double question4_b(E a, E b, E c){
        return a.doubleValue() + b.doubleValue() + c.doubleValue();
    }

    public static <E extends Number> double question4_c(E a, E b, E c, E d){
        return a.doubleValue() + b.doubleValue() + c.doubleValue() + d.doubleValue();
    }

    public static <E extends Number> double question4_d(E a, E b){
        return a.doubleValue() - b.doubleValue();
    }

    public static <E extends Number> double question4_e(E a, E b){
        return Math.pow(a.doubleValue(), b.doubleValue()) ;
    }

}

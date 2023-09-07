package org.example.entity;

public class MyMath {
    public static final double PI = 3.14;
    public static int min(int a, int b){
        return a < b ? a:b;
    }

    public static int sum(int a, int b){
        return a + b;
    }

    public static double sum(int a){
        //MyMath.PI = 3.15;
        return a + MyMath.PI;
    }
}

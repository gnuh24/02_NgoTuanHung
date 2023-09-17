package org.example.frontend;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws Exception{
        Test test = new Test();
        System.out.println(test.add(2,8));
    }

    static class Test{
        static float add(int a, int b) throws Exception{
            return (float) a/b;
        }
    }
}
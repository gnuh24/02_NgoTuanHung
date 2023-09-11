package org.example.entity;

public class MyNumber <N extends Number>{
    public static <N extends Number> N max(N a, N b){
        if (a.doubleValue() > b.doubleValue())
            return a;
        return b;
    }
}


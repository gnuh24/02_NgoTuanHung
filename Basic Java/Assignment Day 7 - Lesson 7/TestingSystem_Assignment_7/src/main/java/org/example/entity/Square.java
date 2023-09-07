package org.example.entity;

public class Square extends HinhHoc{
    private double edge;
    @Override
    public double area() {
        return edge*edge;
    }

    @Override
    public double perimeter() {
        return edge*4;
    }
}

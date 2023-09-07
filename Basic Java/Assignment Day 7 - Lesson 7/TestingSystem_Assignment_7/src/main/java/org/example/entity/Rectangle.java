package org.example.entity;

public class Rectangle extends HinhHoc{
    private double length;
    private double width;
    @Override
    public double area() {
        return length*width;
    }

    @Override
    public double perimeter() {
        return  ( length + width ) * 2;
    }
}

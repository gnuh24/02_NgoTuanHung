package org.example.entity;

public class Circle extends HinhHoc{
    private double radius;

    @Override
    public double area(){
        return radius*radius*Math.PI;
    }

    @Override
    public double perimeter(){
        return radius*2*Math.PI;
    }
}

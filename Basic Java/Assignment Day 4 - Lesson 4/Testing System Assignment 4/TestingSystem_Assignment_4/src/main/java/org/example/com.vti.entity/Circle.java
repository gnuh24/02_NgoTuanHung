package org.example.com.vti.entity;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle(){}

    public Circle(double radius){
        this.radius = radius;
    }

    public Circle(double radius, String color){
        this.radius = radius;
        this.color = color;
    }

    public double getRadius(){
        return this.radius;
    }

    public void setRadius(Double radius){
        this.radius = radius;
    }

    public String getColor(){
        return this.color;
    }

    public void setColor(String color){
        this.color = color;
    }

    public double getArea(){
        return this.radius*this.radius*3.1416;
    }

    public String toString(){
        String result = "";

        result += "Radius: " + this.radius + "\n";
        result += "Color: " + this.color + "\n";
        result += "Area: " + this.getArea() + "\n";

        return result;
    }

}

package org.example;

public class Car {
    private int speed;
    private double regularPrice;
    private String color;
    public double getSalePrice(){
        return regularPrice;
    }

    public String getColor() {
        return color;
    }

    public int getSpeed() {
        return speed;
    }

    public double getRegularPrice() {
        return regularPrice;
    }

    public Car(int speed, double regularPrice, String color){
        this.speed = speed;
        this.regularPrice = regularPrice;
        this.color = color;
    }
}

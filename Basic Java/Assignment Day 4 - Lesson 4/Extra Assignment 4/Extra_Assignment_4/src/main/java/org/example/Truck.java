package org.example;

public class Truck extends Car{
    private int weight;

    @Override
    public double getSalePrice() {
        if (this.weight > 2000)
            return this.getRegularPrice()*0.9;
        return this.getRegularPrice()*0.8;
    }

    public Truck(int speed, double regularPrice, String color, int weight) {
        super(speed, regularPrice, color);
        this.weight = weight;
    }
}

package org.example;

public class Sedan extends Car{
    private int length;

    @Override
    public double getSalePrice() {
        if (this.length > 20)
            return this.getRegularPrice()*0.95;
        return this.getRegularPrice()*0.9;
    }

    public Sedan(int speed, double regularPrice, String color, int length){
        super(speed, regularPrice, color);
        this.length = length;
    }

    public int getLength() {
        return length;
    }
}

package org.example;

public class Ford extends Car{
    private int year;
    private int manufacturerDiscount;
    @Override
    public double getSalePrice() {
        return this.getRegularPrice() - this.manufacturerDiscount*1.0;
    }

    public Ford(int speed, double regularPrice, String color, int year, int manufacturerDiscount){
        super(speed, regularPrice, color);
        this.year = year;
        this.manufacturerDiscount = manufacturerDiscount;
    }

    public int getManufacturerDiscount() {
        return manufacturerDiscount;
    }

    public int getYear() {
        return year;
    }
}

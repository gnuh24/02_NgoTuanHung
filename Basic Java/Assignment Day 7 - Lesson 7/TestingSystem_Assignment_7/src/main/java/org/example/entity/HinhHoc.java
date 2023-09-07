package org.example.entity;

public abstract class HinhHoc {
    private static int number;
    public HinhHoc(){
        number++;
    }
    public abstract double area();
    public abstract double perimeter();

    public void setNumber(int number) {
        HinhHoc.number = number;
    }

    public static int getNumber() {
        return HinhHoc.number;
    }
}

package org.example.exercise2.question3;

public class Square implements Rectangle{

    @Override
    public void calculatePerimeter() {
        System.out.println("Tính chu vi hình chữ nhật");
    }

    @Override
    public void calculateArea() {
        System.out.println("Tính diện tích hình chữ nhật");
    }
}

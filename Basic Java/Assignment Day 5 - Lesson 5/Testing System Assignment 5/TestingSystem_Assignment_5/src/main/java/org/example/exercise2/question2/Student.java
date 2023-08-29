package org.example.exercise2.question2;

import java.util.Scanner;

public class Student extends Person{
    private int id;
    private double avgScore;
    private String email;

    // Getter cho thuộc tính id
    public int getId() {
        return id;
    }

    // Setter cho thuộc tính id
    public void setId(int id) {
        this.id = id;
    }

    // Getter cho thuộc tính avgScore
    public double getAvgScore() {
        return avgScore;
    }

    // Setter cho thuộc tính avgScore
    public void setAvgScore(double avgScore) {
        this.avgScore = avgScore;
    }

    // Getter cho thuộc tính email
    public String getEmail() {
        return email;
    }

    // Setter cho thuộc tính email
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public void inputInfo(){
        Scanner input = new Scanner(System.in);

        System.out.println("Nhập tên: ");
        this.setName(input.nextLine());

        System.out.println("Nhập giới tính: ");
        this.setGender(input.nextLine());

        System.out.println("Nhập ngày sinh: ");
        this.setBirthDate(input.nextLine());

        System.out.println("Nhập địa chỉ: ");
        this.setAddress(input.nextLine());

        System.out.println("Nhập id: ");
        this.setId(input.nextInt());

        System.out.println("Nhập điểm trung bình: ");
        this.setAvgScore(input.nextDouble());

        System.out.println("Nhập email: ");
        this.setEmail(input.nextLine());
    }
    @Override
    public void showInfo() {
        System.out.println("Thông tin của người:");
        System.out.println("Tên: " + this.name);
        System.out.println("Giới tính: " + this.gender);
        System.out.println("Ngày sinh: " + this.birthDate);
        System.out.println("Địa chỉ: " + this.address);

        System.out.println("ID: " + this.id);
        System.out.println("Điểm trung bình: " + this.avgScore);
        System.out.println("Email: " + this.email);

    }

    public boolean isScholarship(){
        return this.avgScore >= 8.0 ;
    }

}

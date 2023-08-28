package org.example.com.vti.entity;

public abstract class User {
    private String name;
    private double salaryRatio;

    public void setName(String name) {
        this.name = name;
    }
    public void setSalaryRatio(double salaryRatio) {
        this.salaryRatio = salaryRatio;
    }

    public String getName() {
        return name;
    }

    public double getSalaryRatio() {
        return salaryRatio;
    }

    public abstract double calculatePay();
    public void displayIn4(){
        System.out.println("Name: " + name);
        System.out.println("Salary: " +  salaryRatio);
    }
}

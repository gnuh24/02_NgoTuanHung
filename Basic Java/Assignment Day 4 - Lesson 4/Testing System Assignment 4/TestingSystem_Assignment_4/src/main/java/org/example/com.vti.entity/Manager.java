package org.example.com.vti.entity;

public class Manager extends User{
    public double calculatePay() {
        return this.getSalaryRatio() * 520;
    }
}

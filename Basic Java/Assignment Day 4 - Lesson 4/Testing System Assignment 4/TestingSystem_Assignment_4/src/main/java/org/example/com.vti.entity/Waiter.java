package org.example.com.vti.entity;

public class Waiter extends User{
    public double calculatePay() {
        return this.getSalaryRatio() * 420;
    }
}

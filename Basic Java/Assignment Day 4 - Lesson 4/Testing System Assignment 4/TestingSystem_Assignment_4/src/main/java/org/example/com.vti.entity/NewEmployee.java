package org.example.com.vti.entity;

public class NewEmployee extends User{


    public double calculatePay() {
        return this.getSalaryRatio() * 420;
    }
}

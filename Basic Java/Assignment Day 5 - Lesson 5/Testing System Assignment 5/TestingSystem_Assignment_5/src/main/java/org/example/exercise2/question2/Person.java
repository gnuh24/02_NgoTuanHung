package org.example.exercise2.question2;

import java.util.Scanner;

public abstract class Person {
    protected String name;
    protected String gender;
    protected String birthDate;
    protected String address;

    public Person() {
    }

    public Person(String name, String gender, String birthDate, String address) {
        this.name = name;
        this.gender = gender;
        this.birthDate = birthDate;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public abstract void inputInfo();

    public abstract  void showInfo() ;



}
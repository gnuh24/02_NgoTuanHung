package org.example.entity;

public class Department {
    private int id;
    private String name;

    public Department(){
        ScannerUtils test = new ScannerUtils();
        this.id = test.inputInt("");
        this.name = test.inputString("");
    }
}

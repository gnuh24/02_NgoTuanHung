package org.example.entity;

import java.util.ArrayList;

public class Group {
    private int id;
    private String name;
    private ArrayList <Account> listOfMember = new ArrayList<>();

    public void addMember(Account newAccount){
        this.listOfMember.add(newAccount);
    }

    public Group(){
        ScannerUtils test = new ScannerUtils();
        this.id =  test.inputInt("");
        this.name = test.inputString("");
        int choice = 0;
        System.out.println("Muốn thêm thành viên mới ?");
        choice = test.inputInt("");

            while (choice == 1) {
                Account newAccount = new Account();
                this.listOfMember.add(newAccount);
                System.out.println("Muốn thêm thành viên mới ?");
                choice = test.inputInt("");
            }

    }
}

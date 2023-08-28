package org.example.com.vti.entity;

import java.util.ArrayList;

public abstract class Phone {
    ArrayList<Contact> listOfContact = new ArrayList<>();
    public abstract void insertContact(String name, String phone);
    public abstract void removeContact(String name);
    public abstract void updateContact(String name, String newPhone);
    public abstract void searchContact(String name);
}

class Contact{
    private String name;
    private String number;

    public Contact(String name, String phone){
        this.name = name;
        this.number = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}

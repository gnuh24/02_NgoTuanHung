package org.example.com.vti.entity;

public class VietnamesePhoneNumber extends Phone {


    public void insertContact(String name, String phone) {
        Contact newContact = new Contact(name, phone);
        this.listOfContact.add(newContact);
        System.out.println("Add contact thành công ^^");
    }

    public void removeContact(String name) {
        for (Contact i: this.listOfContact)
            if (i.getName().equals(name)) {
                this.listOfContact.remove(i);
                break;
            }
    }

    public void updateContact(String name, String newPhone) {
        for (Contact i: this.listOfContact)
            if (i.getName().equals(name)) {
                i.setNumber(newPhone);
                break;
            }
    }

    public void searchContact(String name) {
        for (Contact i: this.listOfContact)
            if (i.getName().equals(name)) {
                System.out.println("Tên: " + i.getName());
                System.out.println("Phone: " + i.getNumber());
            }
    }
}

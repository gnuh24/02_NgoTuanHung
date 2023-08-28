package org.example.com.vti.entity;

public class VietnamesePhoneNumber extends Phone {


    public void insertContact(String name, String phone) {
        Contact newContact = new Contact(name, phone);
        this.listOfContact.add(newContact);
        System.out.println("Thêm thành công ^^");
    }

    public void removeContact(String name) {
        Contact target = null;

        for (Contact i: this.listOfContact)
            if (i.getName().equals(name)) {
                target = i;
                break;
            }

        if (target != null)
            System.out.println("Xóa thành công ^^");
        else
            System.out.println("Xóa thất bại, không tìm thấy đối tượng để xóa ^^");

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

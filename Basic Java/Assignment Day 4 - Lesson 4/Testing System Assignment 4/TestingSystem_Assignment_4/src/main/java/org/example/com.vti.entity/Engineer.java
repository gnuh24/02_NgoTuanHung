package org.example.com.vti.entity;

import org.example.com.vti.entity.CanBo;

public class Engineer extends CanBo {
    private String subject;
    public Engineer(String name, int age, enumGender gender, String address, String subject) {
        super(name, age, gender, address);
        this.subject = subject;
    }
}

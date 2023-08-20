package org.example.classes;

import java.util.Date;

public class Account {
    public short accountID;
    public String email;
    public String username;
    public String fullName;
    public byte departmentID;
    public byte positionID;
    public Date createDate;

    public Account(short accountID, String email, String username, String fullName, byte departmentID, byte positionID, Date createDate) {
        this.accountID = accountID;
        this.email = email;
        this.username = username;
        this.fullName = fullName;
        this.departmentID = departmentID;
        this.positionID = positionID;
        this.createDate = createDate;
    }
}

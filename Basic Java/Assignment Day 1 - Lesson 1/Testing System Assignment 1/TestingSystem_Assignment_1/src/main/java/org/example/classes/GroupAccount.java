package org.example.classes;
import java.util.Date;
public class GroupAccount {
    public byte groupID;
    public short accountID;
    public Date JoinDate;
    public GroupAccount(byte groupID, short accountID, Date joinDate) {
        this.groupID = groupID;
        this.accountID = accountID;
        this.JoinDate = joinDate;
    }
}

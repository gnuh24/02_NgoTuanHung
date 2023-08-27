package org.example.com.vti.entity;
import java.util.Date;
public class GroupAccount {
    private byte groupID;
    private short accountID;
    private Date joinDate;
    public byte getGroupID() {
        return groupID;
    }

    public void setGroupID(byte groupID) {
        this.groupID = groupID;
    }

    public short getAccountID() {
        return accountID;
    }

    public void setAccountID(short accountID) {
        this.accountID = accountID;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }
    public GroupAccount(byte groupID, short accountID, Date joinDate) {
        this.groupID = groupID;
        this.accountID = accountID;
        this.joinDate = joinDate;
    }
}

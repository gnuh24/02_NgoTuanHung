package org.example.com.vti.entity;
import java.lang.reflect.Array;
import java.util.Date;
public class Group {
    private byte groupID;
    private String groupName;
    private Account creator;
    private Account [] arrayOfMembers;
    private String [] arrayStringOfMembers;


    public Date createDate;

    public byte getGroupID() {
        return groupID;
    }

    public void setGroupID(byte groupID) {
        this.groupID = groupID;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public Account getCreator() {
        return creator;
    }

    public void setCreator(Account creator) {
        this.creator = creator;
    }

    public Account[] getArrayOfMembers() {
        return arrayOfMembers;
    }

    public void setArrayOfMembers(Account[] arrayOfMembers) {
        this.arrayOfMembers = arrayOfMembers;
    }

    public String[] getArrayStringOfMembers() {
        return arrayStringOfMembers;
    }

    public void setArrayStringOfMembers(String[] arrayStringOfMembers) {
        this.arrayStringOfMembers = arrayStringOfMembers;
    }

    /* Question 3:
        Tạo constructor cho Group:
        a) không có parameters
        b) Có các parameter là GroupName, Creator, array Account[]
        accounts, CreateDate
        c) Có các parameter là GroupName, Creator, array String[]
        usernames , CreateDate
        Với mỗi username thì sẽ khởi tạo 1 Account (chỉ có thông tin
        username, các thông tin còn lại = null).
        Khởi tạo 1 Object với mỗi constructor ở trên*/
    public Group() {}
    public Group(String groupName, Account creator, Date createDate, Account [] array) {
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
        this.arrayOfMembers = array;
    }
    public Group(String groupName, Account creator, Date createDate, String [] array) {
        this.groupName = groupName;
        this.creator = creator;
        this.createDate = createDate;
        this.arrayStringOfMembers = array;
    }
}

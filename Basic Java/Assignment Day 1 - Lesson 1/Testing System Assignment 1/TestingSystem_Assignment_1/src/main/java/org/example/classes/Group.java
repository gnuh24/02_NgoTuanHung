package org.example.classes;
import java.util.Date;
public class Group {
    public byte groupID;
    public String GroupName;
    public short CreatorID;
    public Date createDate;

    public Group(byte groupID, String groupName, short creatorID, Date createDate) {
        this.groupID = groupID;
        this.GroupName = groupName;
        this.CreatorID = creatorID;
        this.createDate = createDate;
    }
}

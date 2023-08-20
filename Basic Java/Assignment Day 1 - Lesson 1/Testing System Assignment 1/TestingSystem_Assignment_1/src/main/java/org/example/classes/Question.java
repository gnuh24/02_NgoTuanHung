package org.example.classes;
import java.util.Date;
public class Question {
    public int questionID;
    public String Content;
    public byte categoryID;
    public byte typeID;
    public short creatorID;
    public Date createDate;
    public Question(int questionID, String content, byte categoryID, byte typeID, short creatorID, Date createDate) {
        this.questionID = questionID;
        this.Content = content;
        this.categoryID = categoryID;
        this.typeID = typeID;
        this.creatorID = creatorID;
        this.createDate = createDate;
    }
}

package org.example.com.vti.entity;
import java.util.Date;
public class Question {
    private int questionID;
    private String content;
    private byte categoryID;
    private byte typeID;
    private short creatorID;
    private Date createDate;
    public int getQuestionID() {
        return questionID;
    }

    public void setQuestionID(int questionID) {
        this.questionID = questionID;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public byte getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(byte categoryID) {
        this.categoryID = categoryID;
    }

    public byte getTypeID() {
        return typeID;
    }

    public void setTypeID(byte typeID) {
        this.typeID = typeID;
    }

    public short getCreatorID() {
        return creatorID;
    }

    public void setCreatorID(short creatorID) {
        this.creatorID = creatorID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
    public Question(int questionID, String content, byte categoryID, byte typeID, short creatorID, Date createDate) {
        this.questionID = questionID;
        this.content = content;
        this.categoryID = categoryID;
        this.typeID = typeID;
        this.creatorID = creatorID;
        this.createDate = createDate;
    }
}

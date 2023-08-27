package org.example.com.vti.entity;
import java.util.Date;
public class Exam {
    private int examID;
    private int code;
    private String title;
    private byte categoryID;
    private short duration;
    private short creatorID;
    private Date createDate;
    public int getExamID() {
        return examID;
    }

    public void setExamID(int examID) {
        this.examID = examID;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public byte getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(byte categoryID) {
        this.categoryID = categoryID;
    }

    public short getDuration() {
        return duration;
    }

    public void setDuration(short duration) {
        this.duration = duration;
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

     public Exam(int examID, int code, String title, byte categoryID, short duration, short creatorID, Date createDate) {
        this.examID = examID;
        this.code = code;
        this.title = title;
        this.categoryID = categoryID;
        this.duration = duration;
        this.creatorID = creatorID;
        this.createDate = createDate;
    }
}

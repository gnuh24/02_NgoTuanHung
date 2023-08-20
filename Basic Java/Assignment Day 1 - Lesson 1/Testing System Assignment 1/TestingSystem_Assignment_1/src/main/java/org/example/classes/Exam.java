package org.example.classes;
import java.util.Date;
public class Exam {
    public int examID;
    public int code;
    public String title;
    public byte categoryID;
    public short duration;
    public short creatorID;
    public Date createDate;

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

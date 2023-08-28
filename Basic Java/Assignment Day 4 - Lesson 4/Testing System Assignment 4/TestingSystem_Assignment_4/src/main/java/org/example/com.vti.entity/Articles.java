package org.example.com.vti.entity;

public class Articles extends Document{
    private final Date date;
    public Articles(int documentID, String publisher, int relase, Date date) {
        super(documentID, publisher, relase);
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void in4(){
        System.out.println("Thông tin tài liệu: " + this.getDocumentID());
        System.out.println("Tên nhà xuất bản: " + this.getPublisher());
        System.out.println("Số bản phát hành: " + this.getRelase());
        System.out.println("Ngày phát hành: " + this.getDate());

    }
}

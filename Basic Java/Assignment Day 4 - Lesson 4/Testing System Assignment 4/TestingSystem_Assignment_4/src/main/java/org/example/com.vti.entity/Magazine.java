package org.example.com.vti.entity;
import org.example.com.vti.entity.Document;

public class Magazine extends Document{
    private int relaseVersion;
    private int relaseVersionMonth;

    public int getRelaseVersion() {
        return relaseVersion;
    }

    public int getRelaseVersionMonth() {
        return relaseVersionMonth;
    }

    public Magazine(int id, String publisher, int relase, int relaseVersion, int relaseVersionMonth){
        super(id, publisher, relase);
        this.relaseVersion = relaseVersion;
        this.relaseVersionMonth = relaseVersionMonth;
    }
    public void in4(){
        System.out.println("Thông tin tài liệu: " + this.getDocumentID());
        System.out.println("Tên nhà xuất bản: " + this.getPublisher());
        System.out.println("Số bản phát hành: " + this.getRelase());
        System.out.println("Phiên bản phát hành: " + this.getRelaseVersion());
        System.out.println("Tháng phát hành: " + this.getRelaseVersionMonth());
    }
}

package org.example.com.vti.entity;

public class Book extends Document{
    private String autor;
    private int pages;

    public int getPages() {
        return pages;
    }

    public String getAutor() {
        return autor;
    }

    public Book(int id, String publisher, int relase, String autor, int pages){
        super(id, publisher, relase);
        this.autor = autor;
        this.pages = pages;
    }
    public void in4(){
        System.out.println("Thông tin tài liệu: " + this.getDocumentID());
        System.out.println("Tên nhà xuất bản: " + this.getPublisher());
        System.out.println("Số bản phát hành: " + this.getRelase());
        System.out.println("Tácc giả: " + this.getAutor());
        System.out.println("Số trang: " + this.getPages());
    }
}

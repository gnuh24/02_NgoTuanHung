package org.example.exercise1.question1;

import org.example.exercise1.question1.INews;

public class News implements INews {
    private int id;
    private String title;
    private String publishDate;
    private String author;
    private String content;
    private float averageRate;

    private int [] rates = new int[3];

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public String getAutor() {
        return author;
    }

    public void setAutor(String autor) {
        this.author = autor;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public float getAverageRate() {
        return averageRate;
    }

    public News(String title, String publishDate, String author, String content, int a, int b, int c){
        this.title = title;
        this.publishDate = publishDate;
        this.content = content;
        this.author = author;
        this.rates[0] = a;
        this.rates[1] = b;
        this.rates[2] = c;

    }
    @Override
    public void display(){
        System.out.println("Title: " + this.title);
        System.out.println("PublishDate: " + this.publishDate);
        System.out.println("Autor: " + this.author);
        System.out.println("Content: " + this.content);
        System.out.println("Average Rate: " + this.averageRate);
    }
    @Override
    public void calculate(){
        this.averageRate = ( (float) this.rates[0]  + this.rates[1] + this.rates[2] ) / 3;
    }

}

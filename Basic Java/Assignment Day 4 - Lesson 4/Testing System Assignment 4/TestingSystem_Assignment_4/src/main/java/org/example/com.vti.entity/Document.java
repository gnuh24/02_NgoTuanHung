package org.example.com.vti.entity;

public class Document {
    private int documentID;
    private String publisher;
    private int relase;

    public int getDocumentID() {
        return documentID;
    }

    public String getPublisher() {
        return publisher;
    }

    public int getRelase() {
        return relase;
    }


    public Document(int documentID, String publisher, int relase){
        this.documentID = documentID;
        this.publisher = publisher;
        this.relase = relase;
    }
}

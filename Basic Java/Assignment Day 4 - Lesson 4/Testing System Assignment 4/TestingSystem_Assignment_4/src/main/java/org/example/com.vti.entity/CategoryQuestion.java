package org.example.com.vti.entity;

public class CategoryQuestion {
    private byte categoryID;
    private String categoryName;
    // Getter methods
    public byte getCategoryID() {
        return categoryID;
    }

    public String getCategoryName() {
        return categoryName;
    }

    // Setter methods
    public void setCategoryID(byte categoryID) {
        this.categoryID = categoryID;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public CategoryQuestion(byte categoryID, String categoryName) {
        this.categoryID = categoryID;
        this.categoryName = categoryName;
    }
}

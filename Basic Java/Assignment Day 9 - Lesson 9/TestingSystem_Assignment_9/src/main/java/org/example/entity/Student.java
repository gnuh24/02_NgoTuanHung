package org.example.entity;

public class Student {
    private int id;
    private String name;

    // Constructor
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter cho thuộc tính 'id'
    /**
     * @deprecated This method is deprecated. Please use {@link #newGetID()} instead.
     */
    @Deprecated
    public int getId() {
        return id;
    }

    public String newGetID(){
        return "MSV: " + this.id;
    }


}

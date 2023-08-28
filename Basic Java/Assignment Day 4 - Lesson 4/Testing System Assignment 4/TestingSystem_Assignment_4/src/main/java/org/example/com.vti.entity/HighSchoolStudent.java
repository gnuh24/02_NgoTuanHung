package org.example.com.vti.entity;

public class HighSchoolStudent extends NewStudent
{
    String clazz;
    String desiredUni;
    public HighSchoolStudent(int id, String name, String clazz, String desiredUni){
        super(id, name);
        this.clazz =clazz;
        this.desiredUni =desiredUni;
    }
}

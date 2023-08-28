package org.example.com.vti.entity;

public class Student {
    private int studentID;
    private String name;
    private String homeTown;
    private float academicPerformance = 0f;

    public Student(String name, String homeTown){
        this.name = name;
        this.homeTown = homeTown;
    }

    public void setAcademicPerformance(float academicPerformance){
        this.academicPerformance = academicPerformance;
    }

    public void appendBonusScores(float bonusScores){
        this.academicPerformance += bonusScores;
    }

    public void in4(){
        System.out.println("Thông tin học sinh ^^");
        System.out.println("Họ tên " + this.name);
        if (this.academicPerformance < 4)
            System.out.println("Học sinh yếu");
        else if (this.academicPerformance > 4 && this.academicPerformance <= 6)
            System.out.println("Học sinh trung bình");
        else if (this.academicPerformance > 6 && this.academicPerformance <= 8)
            System.out.println("Học sinh khá");
        else if (this.academicPerformance > 8)
            System.out.println("Học sinh giỏi");
    }

}

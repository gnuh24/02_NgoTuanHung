package org.example.com.vti.frontend;
import org.example.com.vti.entity.Student;
import org.example.com.vti.entity.HighSchoolStudent;

public class Program1 {
    public static void main(String[] args) {
        Student student1 = new Student("Ngô Tuấn Hưng", "01 Nguyễn Trãi =))");
        student1.setAcademicPerformance(5.2f);
        student1.appendBonusScores(4.0f);
        student1.in4();

        HighSchoolStudent new1 = new HighSchoolStudent(1, "Nam", "Chuyên Văn", "Đại học Công Nghệ") ;
    }

}
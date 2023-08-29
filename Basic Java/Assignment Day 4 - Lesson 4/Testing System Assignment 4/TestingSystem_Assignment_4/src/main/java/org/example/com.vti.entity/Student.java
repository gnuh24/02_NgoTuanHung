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
    /*a) Tất cả các property sẽ để là private để các class khác không
            chỉnh sửa hay nhìn thấy
            b) Tạo constructor cho phép khi khởi tạo mỗi student thì người
    dùng sẽ nhập vào tên, hometown và có điểm học lực = 0
    c) Tạo 1 method cho phép set điểm vào
    d) Tạo 1 method cho phép cộng thêm điểm
    e) Tạo 1 method để in ra thông tin của sinh viên bao gồm có tên,
    điểm học lực ( nếu điểm <4.0 thì sẽ in ra là Yếu, nếu điểm >
            4.0 và < 6.0 thì sẽ in ra là trung bình, nếu điểm > 6.0 và < 8.0
                           thì sẽ in ra là khá, nếu > 8.0 thì in ra là Giỏi)*/
    public void setAcademicPerformance(float academicPerformance){
        this.academicPerformance = academicPerformance;
    }

    public void appendBonusScores(float bonusScores){
        this.academicPerformance += bonusScores;
    }

    public void in4(){
        // -> Hạn che so sánh giữa 2 kiểu dữ liệu khác nhau
        System.out.println("Thông tin học sinh ^^");
        System.out.println("Họ tên " + this.name);
        if (this.academicPerformance < 0.0 || this.academicPerformance > 10.0)
            System.out.println("Điểm không hợp lệ ");
        else if (this.academicPerformance <= 4.0)
            System.out.println("Học sinh yếu");
        else if (this.academicPerformance <= 6.0)
            System.out.println("Học sinh trung bình");
        else if (this.academicPerformance <= 8.0)
            System.out.println("Học sinh khá");
        else
            System.out.println("Học sinh giỏi");
    }

}

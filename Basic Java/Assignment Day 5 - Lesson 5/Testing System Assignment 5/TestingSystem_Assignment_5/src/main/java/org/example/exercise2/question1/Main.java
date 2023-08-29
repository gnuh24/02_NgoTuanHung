package org.example.exercise2.question1;

public class Main {
    public static void main(String[] args) {

        //a) Tạo 10 học sinh, chia thành 3 nhóm
        Student student1 = new Student(1, "Ngô Tuấn Hưng 1", 1);
        Student student2 = new Student(2, "Ngô Tuấn Hưng 2", 2);
        Student student3 = new Student(3, "Ngô Tuấn Hưng 3", 3);
        Student student4 = new Student(4, "Ngô Tuấn Hưng 4", 1);
        Student student5 = new Student(5, "Ngô Tuấn Hưng 5", 2);
        Student student6 = new Student(6, "Ngô Tuấn Hưng 6", 3);
        Student student7 = new Student(7, "Ngô Tuấn Hưng 7", 2);
        Student student8 = new Student(8, "Ngô Tuấn Hưng 8", 1);
        Student student9 = new Student(9, "Ngô Tuấn Hưng 9", 1);
        Student student10 = new Student(10, "Ngô Tuấn Hưng 10", 3);
        Student [] listOfStudents = { student1, student2,student3, student4,student5 ,student6,student7,student8,student9, student10};

        //b) Kêu gọi cả lớp điểm danh.
        for(Student i: listOfStudents)
            i.rollCall();

        //c) Gọi nhóm 1 đi học bài
        for(Student i: listOfStudents)
            if (i.getGroup() == 1)
                i.learning();

        //d) Gọi nhóm 2 đi dọn vệ sinh
        for(Student i: listOfStudents)
            if (i.getGroup() == 2)
                i.cleaningUp();
    }
}

package org.example.backend;
import org.example.entity.*;
public class Exercise_1 {
    public void question1() {
        Student student1 = new Student("Nguyễn Văn A");
        Student student2 = new Student("Nguyễn Văn B");
        Student student3 = new Student("Nguyễn Văn C");
        Student [] list = new Student[3];
        Student.setCollege("Đại học Bách Khoa");

        list[0] = student1;         list[1] = student2;         list[2] = student3;
        for (Student i: list)
            System.out.println(i.getName() + " " + i.getCollege());

        Student.setCollege("Đại học Công Nghệ");
        for (Student i: list)
            System.out.println(i.getName() + " " + i.getCollege());
    }

    public void question2() {
        Student student1 = new Student("Nguyễn Văn A");
        Student student2 = new Student("Nguyễn Văn B");
        Student student3 = new Student("Nguyễn Văn C");
        Student [] list = new Student[3];
        Student.setCollege("Đại học Bách Khoa");

        list[0] = student1;         list[1] = student2;         list[2] = student3;

        // Đóng quỹ ^^
        for (Student i: list)
            Student.setMoneyGroup(Student.getMoneyGroup() + 100000);
        System.out.println("Đã đóng quỹ ^^");
        System.out.println(Student.getMoneyGroup());

        Student.setMoneyGroup(Student.getMoneyGroup() - 50000);
        System.out.println("Student1 đã tiêu 50k cho kẹo bim bim ^^");
        System.out.println(Student.getMoneyGroup());


        Student.setMoneyGroup(Student.getMoneyGroup() - 20000);
        System.out.println("Student2 đã tiêu 20k cho bánh mì ^^");
        System.out.println(Student.getMoneyGroup());

        Student.setMoneyGroup(Student.getMoneyGroup() - 150000);
        System.out.println("Student3 đã tiêu 150k để mua đồ dùng học tập cho nhóm ^^");
        System.out.println(Student.getMoneyGroup());

        // Đóng quỹ ^^
        for (Student i: list)
            Student.setMoneyGroup(Student.getMoneyGroup() + 50000);
        System.out.println("Đã đóng quỹ ^^");
        System.out.println(Student.getMoneyGroup());

    }

    public void question6() {
        Student stu1 = new PrimaryStudent("Nguyen Van A");
        Student stu2 = new PrimaryStudent("Nguyen Van B");
        Student stu3 = new SecordaryStudent("Nguyen Van C");
        Student stu4 = new SecordaryStudent("Nguyen Van D");
        Student stu5 = new SecordaryStudent("Nguyen Van E");
        Student stu6 = new SecordaryStudent("Nguyen Van F");

        System.out.println(Student.getNumberOfStudents());
        System.out.println(PrimaryStudent.getNumberOfPrimaryStudent());
        System.out.println(SecordaryStudent.getNumberOfSDS());

    }

    public void question7() throws Exception{
            for (int i = 1; i <= 8; i++) {
                if (Student.getNumberOfStudents() == 7)
                    throw new Exception("Bạn chỉ có thể tạo tối đa 7 student");
                new Student("A");
            }
    }

    public void question8() {
        try {
            for (int i = 1; i <= 6; i++) {
                if (Configs.getSoLuongHinhToiDa() == HinhHoc.getNumber())
                    throw new HinhHocException("Bạn chỉ có thể tạo tối đa " + Configs.getSoLuongHinhToiDa() + " hình");
                new Circle();
            }
        }
        catch (HinhHocException e){
            System.out.println(e.getMessage());
            System.out.println(HinhHoc.getNumber());
        }

    }

}
class HinhHocException extends Exception{
    HinhHocException(String errorText){
        super(errorText);
    }
}
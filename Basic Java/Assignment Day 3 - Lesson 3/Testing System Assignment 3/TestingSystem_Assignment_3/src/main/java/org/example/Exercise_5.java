package org.example;

public class Exercise_5 {
    Department department1 = new Department(1, "IT");
    Department department2 = new Department(2, "Sales");
    Department department3 = new Department(3, "CEO");
    Department department4 = new Department(4, "Manager");
    Department [] list = {department1, department2, department3, department4};

    /*Question 1:
    In ra thông tin của phòng ban thứ 1 (sử dụng toString())*/
    public static void question1(){
        Exercise_5 test = new Exercise_5();
        test.list[0].in4();
    }

    /*Question 2:
    In ra thông tin của tất cả phòng ban (sử dụng toString())*/
    public static void question2(){
        Exercise_5 test = new Exercise_5();
        for (Department i: test.list){
            i.in4();
        }
    }
    /*Question 3:
    In ra địa chỉ của phòng ban thứ 1*/
    public static void question3(){
        Exercise_5 test = new Exercise_5();

        System.out.println(test.list[0].departmentID);
    }
    /*Question 4: Kiểm tra xem phòng ban thứ 1 có tên là "Phòng A" không?*/
    public static void question4(){
        Exercise_5 test = new Exercise_5();

        if (test.list[0].departmentName.equals("Phòng A"))
                System.out.println("Phòng ban thứ 1 có tên là phòng A");
        else    System.out.println("Phòng ban thứ 1 không có tên là phòng A");

    }
    /*Question 5: So sánh 2 phòng ban thứ 1 và phòng ban thứ 2 xem có bằng nhau
    không (bằng nhau khi tên của 2 phòng ban đó bằng nhau)*/
    public static void question5(){
        Exercise_5 test = new Exercise_5();
        if (test.list[0].departmentName.equals(test.list[1].departmentName))
                System.out.println("Phòng ban thứ 1 có tên bằng với phòng ban thứ 2");
        else    System.out.println("Phòng ban thứ 1 có tên không bằng với phòng ban thứ 2");
    }
    /*Question 6: Khởi tạo 1 array phòng ban gồm 5 phòng ban, sau đó in ra danh
    sách phòng ban theo thứ tự tăng dần theo tên (sắp xếp theo vần ABCD)
    VD:
    Accounting
    Boss of director
            Marketing
    Sale
    Waiting room*/
    public static void question6(){
        Exercise_5 test = new Exercise_5();

        for (int i=0; i< test.list.length-1; i++){
            for (int j = i+1; j < test.list.length; j++){
                if (test.list[i].departmentName.compareTo(test.list[j].departmentName) > 0) {
                    Department temp = test.list[i];
                    test.list[i] = test.list[j];
                    test.list[j] = temp;
                }
            }

        }

        for (Department i: test.list){
            System.out.println(i.departmentID);
            System.out.println(i.departmentName);

        }
    }

    /*Question 7: Khởi tạo 1 array học sinh gồm 5 Phòng ban, sau đó in ra danh
    sách phòng ban được sắp xếp theo tên
    VD:
    Accounting
    Boss of director
            Marketing
    waiting room
    Sale*/
}

class Department{
    int departmentID;
    String departmentName;
    Department(int departmentID, String departmentName){
        this.departmentID = departmentID;
        this.departmentName = departmentName;
    }


    void in4(){
        System.out.println("ID: " + this.departmentID);
        System.out.println("DepartmentName: " + this.departmentName);
    }
}

package org.example;

import org.example.classes.*;

import java.text.DateFormat;
import java.util.Date;
import org.example.classes.Position.*;
import org.example.classes.TypeQuestion.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Random;


public class Program {
    public static void main(String[] args) {
        // Create objects of class Account
        Account account1 = new Account((short) 1, "email1@example.com", "user1", "User One", (byte) 1, (byte) 1, new Date());
        Account account2 = new Account((short) 2, "email2@example.com", "user2", "User Two", (byte) 2, (byte) 2, new Date());
        Account account3 = new Account((short) 3, "email3@example.com", "user3", "User Three", (byte) 3, (byte) 3, new Date());
        System.out.println(account1.createDate);
        System.out.println(account2.createDate);
        System.out.println(account3.createDate);


        // Create objects of class Answer
        Answer answer1 = new Answer(1, "Content 1", 1, true);
        Answer answer2 = new Answer(2, "Content 2", 2, false);
        Answer answer3 = new Answer(3, "Content 3", 3, true);

        // Create objects of class Department
        Department department1 = new Department((byte) 1, "IT");
        Department department2 = new Department((byte) 2, "HR");
        Department department3 = new Department((byte) 3, "Finance");

        // Create objects of class Exam
        Exam exam1 = new Exam(1, 101, "Java Basics", (byte) 1, (short) 120, (short) 1, new Date());
        Exam exam2 = new Exam(2, 102, "OOP Concepts", (byte) 2, (short) 90, (short) 2, new Date());
        Exam exam3 = new Exam(3, 103, "Database Fundamentals", (byte) 3, (short) 60, (short) 3, new Date());

        // Create objects of class ExamQuestion
        ExamQuestion examQuestion1 = new ExamQuestion(1, 1);
        ExamQuestion examQuestion2 = new ExamQuestion(1, 2);
        ExamQuestion examQuestion3 = new ExamQuestion(2, 3);

        // Create objects of class Group
        Group group1 = new Group((byte) 1, "Group 1", (short) 1, new Date());
        Group group2 = new Group((byte) 2, "Group 2", (short) 2, new Date());
        Group group3 = new Group((byte) 3, "Group 3", (short) 3, new Date());

        // Create objects of class GroupAccount
        GroupAccount groupAccount1 = new GroupAccount((byte) 1, (short) 1, new Date());
        GroupAccount groupAccount2 = new GroupAccount((byte) 2, (short) 2, new Date());
        GroupAccount groupAccount3 = new GroupAccount((byte) 3, (short) 3, new Date());

        // Create objects of class Position
        Position position1 = new Position((byte) 1, EnumPositionName.DEV);
        Position position2 = new Position((byte) 2, EnumPositionName.TEST);
        Position position3 = new Position((byte) 3, EnumPositionName.SCRUM_MASTER);


        // Create objects of class Question
        Question question1 = new Question(1, "Question 1 content", (byte) 1, (byte) 1, (short) 1, new Date());
        Question question2 = new Question(2, "Question 2 content", (byte) 2, (byte) 2, (short) 2, new Date());
        Question question3 = new Question(3, "Question 3 content", (byte) 3, (byte) 3, (short) 3, new Date());


        //Create objects of class TypeQuestion

        TypeQuestion typeQuestion1 = new TypeQuestion((byte) 1, EnumTypeName.Essay);
        TypeQuestion typeQuestion2 = new TypeQuestion((byte) 2, EnumTypeName.Multiple_Choice);


        /*  __________________________________________TestingSystem_Assignment_2_______________________________________________________*/
        /*Question 1:
            Kiểm tra account thứ 2
            Nếu không có phòng ban (tức là department == null) thì sẽ in ra text
            "Nhân viên này chưa có phòng ban"
            Nếu không thì sẽ in ra text "Phòng ban của nhân viên này là ..."
            NOTE!! Kiểu dữ liệu nguyên thủy không thể so sánh được với null */
        System.out.println("______________________________Question 1____________________________________");

        if (account2.departmentID  == 0)
            System.out.println("Nhân viên này chưa có phòng ban");
        else  System.out.println("Phòng ban của nhân viên này là " + account2.departmentID);

        /*Question 2:
            Kiểm tra account thứ 2
            Nếu không có group thì sẽ in ra text "Nhân viên này chưa có group"
            Nếu có mặt trong 1 hoặc 2 group thì sẽ in ra text "Group của nhân viên
            này là Java Fresher, C# Fresher"
            Nếu có mặt trong 3 Group thì sẽ in ra text "Nhân viên này là người
            quan trọng, tham gia nhiều group"
            Nếu có mặt trong 4 group trở lên thì sẽ in ra text "Nhân viên này là
            người hóng chuyện, tham gia tất cả các group"*/

        System.out.println("______________________________Question 2____________________________________");
        /* Question 3:
        Sử dụng toán tử ternary để làm Question 1*/
        System.out.println("______________________________Question 3____________________________________");
        String Question3 = account2.departmentID  == 0 ?  "Nhân viên này chưa có phòng ban": "Phòng ban của nhân viên này là " + account2.departmentID ;
        System.out.println(Question3);


        /*Question 4:
        Sử dụng toán tử ternary để làm yêu cầu sau:
        Kiểm tra Position của account thứ 1
        Nếu Position = Dev thì in ra text "Đây là Developer"
        Nếu không phải thì in ra text "Người này không phải là Developer"*/
        System.out.println("______________________________Question 4____________________________________");
        String Question4 = account1.positionID == 1? "Đây là Developer" : "Người này không phải là Developer";
        System.out.println(Question4);

        /*Question 5:
        Lấy ra số lượng account trong nhóm thứ 1 và in ra theo format sau:
        Nếu số lượng account = 1 thì in ra "Nhóm có một thành viên"
        Nếu số lượng account = 2 thì in ra "Nhóm có hai thành viên"
        Nếu số lượng account = 3 thì in ra "Nhóm có ba thành viên"
        Còn lại in ra "Nhóm có nhiều thành viên"*/
        System.out.println("______________________________Question 5____________________________________");
        //Tạo list các account
        ArrayList<Byte> listOfGroupAccount = new ArrayList<>();
        listOfGroupAccount.add(groupAccount1.groupID);
        listOfGroupAccount.add(groupAccount2.groupID);
        listOfGroupAccount.add(groupAccount3.groupID);
        System.out.println(listOfGroupAccount);

        //Đếm số lượng account trong group 1
        int countGroup1 = 0;
        for (byte i: listOfGroupAccount)
            if (i == 1)
                countGroup1++;

        switch (countGroup1){
            case 0:
                System.out.println("Nhóm không có thành viên nào");
                break;
            case 1:
                System.out.println("Nhóm có 1 thành viên");
                break;
            case 2:
                System.out.println("Nhóm có 2 thành viên");
                break;
            case 3:
                System.out.println("Nhóm có 3 thành viên");
                break;
            default:
                System.out.println("Nhóm có nhiều thành viên");
                break;
        }

        /*Question 6:
        Sử dụng switch case để làm lại Question 2*/
        System.out.println("______________________________Question 6____________________________________");


        /*Question 7:
        Sử dụng switch case để làm lại Question 4*/
        System.out.println("______________________________Question 7____________________________________ ");

        switch (account2.positionID) {
            case 1:
                System.out.println("Đây là Developer");
                break;
            default:
                System.out.println("Người này không phải là Developer");
        }

        /*FOREACH
        Question 8:
        In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của họ*/
        System.out.println("______________________________Question 8____________________________________ ");
        ArrayList<Account> listOfAccount = new ArrayList<>();
        listOfAccount.add(account1);
        listOfAccount.add(account2);
        listOfAccount.add(account3);

        for (Account i: listOfAccount)
            i.displayIn4();


        /*Question 9:
        In ra thông tin các phòng ban bao gồm: id và name*/
        System.out.println("______________________________Question 9____________________________________ ");
        ArrayList<Department> listOfDepartment = new ArrayList<>();
        listOfDepartment.add(department1);
        listOfDepartment.add(department2);
        listOfDepartment.add(department3);

        for (Department i: listOfDepartment)
            i.displayIn4();

        /*FOR
        Question 10:
        In ra thông tin các account bao gồm: Email, FullName và tên phòng ban của
        họ theo định dạng như sau:
        Thông tin account thứ 1 là:
        Email: NguyenVanA@gmail.com
        Full name: Nguyễn Văn A
        Phòng ban: Sale
        Thông tin account thứ 2 là:
        Email: NguyenVanB@gmail.com
        Full name: Nguyễn Văn B
        Phòng ban: Marketting
        */
        System.out.println("______________________________Question 10____________________________________ ");

        for (int i=0; i< listOfAccount.size(); i++)
            listOfAccount.get(i).displayIn4();
        /*
        Question 11:
        In ra thông tin các phòng ban bao gồm: id và name theo định dạng sau:
        Thông tin department thứ 1 là:
        Id: 1
        Name: Sale
        Thông tin department thứ 2 là:
        Id: 2
        Name: Marketing*/
        System.out.println("______________________________Question 11____________________________________ ");
        for (Department i : listOfDepartment)
            i.displayIn4();


        /*
        Question 12:
        Chỉ in ra thông tin 2 department đầu tiên theo định dạng như Question 10*/
        System.out.println("______________________________Question 12____________________________________ ");
        for (int i=0; i<2; i++)
            listOfDepartment.get(i).displayIn4();

        /*Question 13:
        In ra thông tin tất cả các account ngoại trừ account thứ 2*/
        System.out.println("______________________________Question 13____________________________________ ");
        for (Account i: listOfAccount){
            if (i.accountID == 2)
                continue;
            i.displayIn4();}

        /*Question 14:
        In ra thông tin tất cả các account có id < 4*/
        System.out.println("______________________________Question 14____________________________________ ");
        for (Account i: listOfAccount)
            if (i.accountID < 5)
                i.displayIn4();

        /*Question 15:
        In ra các số chẵn nhỏ hơn hoặc bằng 20*/
        System.out.println("______________________________Question 15____________________________________ ");
        for (int i=2; i<21; i = i + 2)
            System.out.print(i + " ");
        System.out.println();


        /*WHILE
        Question 16:
        Làm lại các Question ở phần FOR bằng cách sử dụng WHILE kết hợp với
        lệnh break, continue*/
        /*DO-WHILE
        Question 17:
        Làm lại các Question ở phần FOR bằng cách sử dụng DO-WHILE kết hợp với
        lệnh break, continue*/


        /*
        Exercise 2 (Optional): System out printf
            Question 1:
            Khai báo 1 số nguyên = 5 và sử dụng lệnh System out printf để in ra số
            nguyên đó*/
        System.out.println("______________________________Ex2 _ Question 1____________________________________ ");

        int ex2_q1 = 5;
        System.out.printf("%d%n" ,ex2_q1);

            /*Question 2:
            Khai báo 1 số nguyên = 100 000 000 và sử dụng lệnh System out printf để in
            ra số nguyên đó thành định dạng như sau: 100,000,000*/
        System.out.println("______________________________Ex2 _ Question 2____________________________________ ");

        int ex2_q2 = 100000000;
        System.out.printf("%,d%n" ,ex2_q2);

            /*Question 3:
            Khai báo 1 số thực = 5,567098 và sử dụng lệnh System out printf để in ra số
            thực đó chỉ bao gồm 4 số đằng sau*/
        System.out.println("______________________________Ex2 _ Question 3____________________________________ ");

        float ex2_q3 = 5.567098f;
        System.out.printf("%.4f%n" ,ex2_q3);
            /*Question 4:
            Khai báo Họ và tên của 1 học sinh và in ra họ và tên học sinh đó theo định
            dạng như sau:
            Họ và tên: "Nguyễn Văn A" thì sẽ in ra trên console như sau:
            Tên tôi là "Nguyễn Văn A" và tôi đang độc thân.*/
        System.out.println("______________________________Ex2 _ Question 4____________________________________ ");
        String nameEx2_Q4 = "Nguyễn Văn A";
        System.out.printf("Tên tôi là \"%s\" và tôi đang độc thân%n", nameEx2_Q4);
            /*Question 5:
            Lấy thời gian bây giờ và in ra theo định dạng sau:
            24/04/2020 11h:16p:20s*/
        System.out.println("______________________________Ex2 _ Question 5____________________________________ ");

        SimpleDateFormat simpleDateFortmatEx2Q5 = new SimpleDateFormat("yy/MM//dd HH'h':mm'p':ss's'");
        System.out.println(simpleDateFortmatEx2Q5.format(new Date()));
            /*Question 6:
            In ra thông tin account (như Question 8 phần FOREACH) theo định dạng
            table (giống trong Database)*/
        System.out.println("______________________________Ex2 _ Question 6____________________________________ ");
        for (Account i: listOfAccount)
            i.displayIn4_table();


        /*Exercise 3 (Optional): Date Format
        Question 1:
        In ra thông tin Exam thứ 1 và property create date sẽ được format theo định
        dạng vietnamese*/
        System.out.println("______________________________Ex3 _ Question 1____________________________________ ");

        Locale locate_ex3_Q1 = new Locale("vietnamese", "VN");
        DateFormat dateFormat_ex3_Q1 = DateFormat.getDateInstance(DateFormat.DEFAULT, locate_ex3_Q1);
        System.out.println(dateFormat_ex3_Q1.format(exam1.createDate) );
        /*Question 2:
        In ra thông tin: Exam đã tạo ngày nào theo định dạng
        Năm – tháng – ngày – giờ – phút – giây*/
        System.out.println("______________________________Ex3 _ Question 2____________________________________ ");

        SimpleDateFormat dateFormat_ex3_Q2 = new SimpleDateFormat("yy - MM - dd - HH - mm- ss");
        System.out.println(dateFormat_ex3_Q2.format(exam1.createDate) );
        /*Question 3:
        Chỉ in ra năm của create date property trong Question 2*/
        System.out.println("______________________________Ex3 _ Question 3____________________________________ ");

        SimpleDateFormat dateFormat_ex3_Q3 = new SimpleDateFormat("yyyy");
        System.out.println(dateFormat_ex3_Q3.format(exam1.createDate));
        /*Question 4:
        Chỉ in ra tháng và năm của create date property trong Question 2*/
        System.out.println("______________________________Ex3 _ Question 4____________________________________ ");
        SimpleDateFormat dateFormat_ex3_Q4 = new SimpleDateFormat("yyyy/MM");
        System.out.println(dateFormat_ex3_Q4.format(exam1.createDate));
        /*Question 5:
        Chỉ in ra "MM-DD" của create date trong Question 2*/
        System.out.println("______________________________Ex3 _ Question 5____________________________________ ");
        SimpleDateFormat dateFormat_ex3_Q5 = new SimpleDateFormat("MM-dd");
        System.out.println(dateFormat_ex3_Q5.format(exam1.createDate));

        /*Exercise 4 (Optional): Random Number

        Question 1:
        In ngẫu nhiên ra 1 số nguyên*/
        System.out.println("______________________________Ex4 _ Question 1____________________________________ ");
        Random random = new Random();
        System.out.println(random.nextInt());
        /*Question 2:
        In ngẫu nhiên ra 1 số thực*/
        /*Question 3:
        Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên
        ra tên của 1 bạn*/
        /*Question 4:
        Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-
                1995*/
        /*Question 5:
        Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây*/
        /*Question 6:
        Lấy ngẫu nhiên 1 ngày trong quá khứ*/
        /*Question 7:
        Lấy ngẫu nhiên 1 số có 3 chữ số*/
    }
}
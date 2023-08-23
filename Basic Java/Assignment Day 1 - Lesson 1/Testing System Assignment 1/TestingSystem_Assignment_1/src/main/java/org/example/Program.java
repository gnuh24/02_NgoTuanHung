
package org.example;

import org.example.classes.*;


import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.util.*;

import org.example.classes.Position.*;
import org.example.classes.TypeQuestion.*;

import java.text.SimpleDateFormat;


public class Program {
    public static void main(String[] args) throws ParseException {
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
        //Tạo list các account
        ArrayList<GroupAccount> listOfGroupAccount = new ArrayList<>();
        listOfGroupAccount.add(groupAccount1);
        listOfGroupAccount.add(groupAccount2);
        listOfGroupAccount.add(groupAccount3);
        int count_ex1_Q2 = 0;
        ArrayList<Byte> listOfGroupOfAccount2 = new ArrayList<>();
        for (GroupAccount i: listOfGroupAccount)
            if (i.accountID == 2){
                count_ex1_Q2++;
                listOfGroupOfAccount2.add(i.groupID);
            }

        if (count_ex1_Q2 == 0)
            System.out.println("Nhân viên này chưa có group");
        else if (count_ex1_Q2 == 1) {
            System.out.print("Group của nhân viên này là ");
            if (listOfGroupOfAccount2.get(0) == 1)
                System.out.println(group1.GroupName);
            else if (listOfGroupOfAccount2.get(0) == 2)
                System.out.println(group2.GroupName);
            else if (listOfGroupOfAccount2.get(0) == 2)
                System.out.println(group3.GroupName);
        }

        else if (count_ex1_Q2 == 2) {
            System.out.print("Group của nhân viên này là ");
            if (listOfGroupOfAccount2.get(0) == 1)
                System.out.println(group1.GroupName);
            else if (listOfGroupOfAccount2.get(0) == 2)
                System.out.println(group2.GroupName);
            else if (listOfGroupOfAccount2.get(0) == 2)
                System.out.println(group3.GroupName);

            if (listOfGroupOfAccount2.get(1) == 1)
                System.out.println(group1.GroupName);
            else if (listOfGroupOfAccount2.get(1) == 2)
                System.out.println(group2.GroupName);
            else if (listOfGroupOfAccount2.get(1) == 2)
                System.out.println(group3.GroupName);
        }
        else if (count_ex1_Q2 == 3)
            System.out.println("Nhân viên này là người quan trọng, tham gia nhiều group");
        else             System.out.println("Nhân viên này là người hóng chuyện, tham gia tất cả các group");



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


        //Đếm số lượng account trong group 1
        int countGroup1 = 0;
        for (GroupAccount i: listOfGroupAccount)
            if (i.accountID == 1)
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
        System.out.println("______________________________Ex4 _ Question 2____________________________________ ");
        System.out.println(random.nextFloat());
        /*Question 3:
        Khai báo 1 array bao gồm các tên của các bạn trong lớp, sau đó in ngẫu nhiên
        ra tên của 1 bạn*/
        System.out.println("______________________________Ex4 _ Question 3____________________________________ ");
        String[] listOfName = {"Ngô Tuấn Hưng 1", "Ngô Tuấn Hưng 2", "Ngô Tuấn Hưng 3", "Ngô Tuấn Hưng 4", "Ngô Tuấn Hưng 5"};
        System.out.println( listOfName[random.nextInt(listOfName.length)]);

        /*Question 4:
        Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 24-07-1995 tới ngày 20-12-
                1995*/
        System.out.println("______________________________Ex4 _ Question 4____________________________________ ");

        int minDay_ex4_Q4 = (int) LocalDate.of(1995, 07, 24).toEpochDay();
        int maxDay_ex4_Q4 = (int) LocalDate.of(1995, 12, 20).toEpochDay();
        long randomInt = minDay_ex4_Q4 + random.nextInt(maxDay_ex4_Q4 - minDay_ex4_Q4);
        LocalDate randomDay = LocalDate.ofEpochDay(randomInt);
        System.out.println(randomDay);

        /*Question 5:
        Lấy ngẫu nhiên 1 ngày trong khoảng thời gian 1 năm trở lại đây*/
        System.out.println("______________________________Ex4 _ Question 5____________________________________ ");

        LocalDate localDate_ex4_Q5 = LocalDate.now();
        int minDay_ex4_Q5 = (int) LocalDate.of(localDate_ex4_Q5.getYear() -1, localDate_ex4_Q5.getMonthValue(), localDate_ex4_Q5.getDayOfMonth()).toEpochDay();
        int maxDay_ex4_Q5 = (int) LocalDate.of(localDate_ex4_Q5.getYear(), localDate_ex4_Q5.getMonthValue(), localDate_ex4_Q5.getDayOfMonth()).toEpochDay();

        long randomInt_ex4_Q5 = minDay_ex4_Q5 + random.nextInt(maxDay_ex4_Q5 - minDay_ex4_Q5);
        LocalDate randomDay_ex4_Q5 = LocalDate.ofEpochDay(randomInt);
        System.out.println(randomDay_ex4_Q5);

        /*Question 6:
        Lấy ngẫu nhiên 1 ngày trong quá khứ*/
        System.out.println("______________________________Ex4 _ Question 6____________________________________ ");

        LocalDate localDate_ex4_Q6 = LocalDate.now();
        int maxDay_ex4_Q6 = (int) LocalDate.of(localDate_ex4_Q6.getYear(), localDate_ex4_Q6.getMonthValue(), localDate_ex4_Q6.getDayOfMonth()).toEpochDay();

        long randomInt_ex4_Q6 = random.nextInt(maxDay_ex4_Q6 );
        LocalDate randomDay_ex4_Q6 = LocalDate.ofEpochDay(randomInt);
        System.out.println(randomDay_ex4_Q6);


        /*Question 7:
        Lấy ngẫu nhiên 1 số có 3 chữ số*/
        System.out.println("______________________________Ex4 _ Question 7____________________________________ ");
        // (0 -> 899) + 100 -> (100 -> 999)
        System.out.println(random.nextInt(900) + 100 );


        /*Exercise 5: Input from console
        Question 1:
        Viết lệnh cho phép người dùng nhập 3 số nguyên vào chương trình*/
        System.out.println("______________________________Ex5 _ Question 1____________________________________ ");

        Scanner input = new Scanner(System.in);
        int a_ex5_Q1 = input.nextInt();
        int b_ex5_Q1 = input.nextInt();
        int c_ex5_Q1 = input.nextInt();

        /*Question 2:
        Viết lệnh cho phép người dùng nhập 2 số thực vào chương trình*/
        System.out.println("______________________________Ex5 _ Question 2____________________________________ ");

        float a_ex_Q2 = input.nextFloat();
        float b_ex_Q2 = input.nextFloat();
        float c_ex_Q2 = input.nextFloat();

        /*Question 3:
        Viết lệnh cho phép người dùng nhập họ và tên*/
        System.out.println("______________________________Ex5 _ Question 3____________________________________ ");
        String name_ex5_Q3 = input.nextLine();
        /*Question 4:
        Viết lệnh cho phép người dùng nhập vào ngày sinh nhật của họ*/
        System.out.println("______________________________Ex5 _ Question 4____________________________________ ");
        String dateString_ex5_Q4 = input.nextLine();
        SimpleDateFormat dateFormat_ex5_Q4 = new SimpleDateFormat("dd/MM/yyyy");
        Date date_ex5_Q4 = dateFormat_ex5_Q4.parse(dateString_ex5_Q4);
        System.out.println(date_ex5_Q4);

        /*Question 5:
        Viết lệnh cho phép người dùng tạo account (viết thành method)
        Đối với property Position, Người dùng nhập vào 1 2 3 4 5 và vào
        chương trình sẽ chuyển thành Position.Dev, Position.Test,
                Position.ScrumMaster, Position.PM*/
        System.out.println("______________________________Ex5 _ Question 5____________________________________ ");

        short accountID = input.nextShort();
        String email = input.nextLine();
        String username = input.nextLine();
        String fullName = input.nextLine();
        byte departmentID = input.nextByte();

        byte positionID = input.nextByte();


        String dateString = input.nextLine();
        SimpleDateFormat simpleDateFormat_e5_Q6 = new SimpleDateFormat("dd/MM/yyyy");
        Date createDate = simpleDateFormat_e5_Q6.parse(dateString);

        Account account4 = new Account(accountID, email, username, fullName, departmentID, positionID, createDate);
        /*Question 6:
        Viết lệnh cho phép người dùng tạo department (viết thành method)*/
        /*Question 7:
        Nhập số chẵn từ console*/
        int a_ex5_Q7;
        do{
            System.out.println("Xin mời nhập số chẵn ^^");
            a_ex5_Q7 = input.nextInt();
        } while(a_ex5_Q7 % 2 != 0);



        /*Question 8:
        Viết chương trình thực hiện theo flow sau:
        Bước 1:
        Chương trình in ra text "mời bạn nhập vào chức năng muốn sử
        dụng"
        Bước 2:
        Nếu người dùng nhập vào 1 thì sẽ thực hiện tạo account
        Nếu người dùng nhập vào 2 thì sẽ thực hiện chức năng tạo
                department
        Nếu người dùng nhập vào số khác thì in ra text "Mời bạn nhập
        lại" và quay trở lại bước 1*/

        /*Question 9:
        Viết method cho phép người dùng thêm group vào account theo flow sau:
        Bước 1:
        In ra tên các usernames của user cho người dùng xem
        Bước 2:
        Yêu cầu người dùng nhập vào username của account
        Bước 3:
        In ra tên các group cho người dùng xem
        Bước 4:
        Yêu cầu người dùng nhập vào tên của group
        Bước 5:
        Dựa vào username và tên của group người dùng vừa chọn, hãy
        thêm account vào group đó .
                Question 10: Tiếp tục Question 8 và Question 9
        Bổ sung thêm vào bước 2 của Question 8 như sau:
        Nếu người dùng nhập vào 3 thì sẽ thực hiện chức năng thêm group vào
                account
        Bổ sung thêm Bước 3 của Question 8 như sau:
        Sau khi người dùng thực hiện xong chức năng ở bước 2 thì in ra dòng
        text để hỏi người dùng "Bạn có muốn thực hiện chức năng khác
        không?". Nếu người dùng chọn "Có" thì quay lại bước 1, nếu người
        dùng chọn "Không" thì kết thúc chương trình (sử dụng lệnh return để
        kết thúc chương trình)*/
        /*Question 11: Tiếp tục Question 10
        Bổ sung thêm vào bước 2 của Question 8 như sau:
        Nếu người dùng nhập vào 4 thì sẽ thực hiện chức năng thêm account
        vào 1 nhóm ngẫu nhiên, chức năng sẽ được cài đặt như sau:
        Bước 1:
        In ra tên các usernames của user cho người dùng xem

        6

        Bước 2:
        Yêu cầu người dùng nhập vào username của account
        Bước 3:
        Sau đó chương trình sẽ chọn ngẫu nhiên 1 group
        Bước 4:
        Thêm account vào group chương trình vừa chọn ngẫu
                nhiên*/



        System.out.println("______________________________Ex6 _ Question 1____________________________________ ");
        Program obj = new Program();
        obj.ex6_Q1();
        System.out.println("______________________________Ex6 _ Question 2____________________________________ ");
        account1.displayIn4();
        System.out.println("______________________________Ex6 _ Question 3____________________________________ ");
        obj.ex6_Q2();


    }

    /*Exercise 6 (Optional): Method
    Question 1:
    Tạo method để in ra các số chẵn nguyên dương nhỏ hơn 10*/
    void ex6_Q1(){
        for (int i=2; i<10; i=i+2)
            System.out.print(i + " ");
    }


    /*Question 2:
    Tạo method để in thông tin các account -> Đã làm ở bên class Account*/

    /*Question 3:
    Tạo method để in ra các số nguyên dương nhỏ hơn 10*/
    void ex6_Q2(){
        for (int i=1; i<10; i++)
            System.out.print(i + " ");
    }
}
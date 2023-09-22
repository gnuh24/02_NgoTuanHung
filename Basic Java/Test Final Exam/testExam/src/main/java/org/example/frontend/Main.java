package org.example.frontend;

import org.example.utils.ScannerUtils;

import java.sql.SQLException;

/***************
 * Họ và tên: Ngô Tuấn Hưng
 ***************/
public class Main {
    public static void main(String[] args) throws SQLException {
        Function function = new Function();
        int choice ;
        do{
            System.out.println("Hãy lựa chọn quyết định của bạn!!\n" +
                    "1. Nhập ID -> Danh sách thành viên\n" +
                    "2. In ra toàn bộ danh sách Manager\n" +
                    "3. Login\n" +
                    "4. Logout");
            choice = ScannerUtils.inputInt("Bạn phải nhập vào số nguyên!!");
            switch (choice) {
                case 1:
                    System.out.println("Nhập vào id  Project bạn muốn kiểm tra!!");
                    function.question1(ScannerUtils.inputInt("Bạn phải nhập vào số nguyên!!"));
                    break;
                case 2:
                    function.question2();
                    break;
                case 3:
                    function.question3();
                    break;
            }
        } while (choice != 4);
    }
}
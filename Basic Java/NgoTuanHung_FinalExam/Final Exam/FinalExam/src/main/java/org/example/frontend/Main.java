package org.example.frontend;

import org.example.utils.ScannerUtils;

import java.sql.SQLException;

/***************
 * Họ và tên: Ngô Tuấn Hưng
 * Hoàn thành vào ngày 22/9/2023 (Thứ 6)
 ***************/
public class Main {
    public static void main(String[] args) throws SQLException {
        Function function = new Function();
        int choice ;
        do{
            System.out.println("Hãy lựa chọn quyết định của bạn!!\n" +
                    "1. Nhập ID -> Danh sách thành viên\n" +
                    "2. Login vào tài khoản ADMIN\n" +
                    "3. Tạo tài khoản mới\n" +
                    "4. Exit");
            choice = ScannerUtils.inputInt("Bạn phải nhập vào số nguyên!!");
            switch (choice) {
                case 1:

                    function.question2();
                    break;
                case 2:
                    function.question3();
                    break;
                case 3:
                    function.question4();
                    break;
                case 4:
                    System.out.println("Cảm ơn bạn đã dùng chương trình này !! Chúc bạn một ngày tốt lành :3 :3");
                    break;
            }
        } while (choice != 4);
    }
}
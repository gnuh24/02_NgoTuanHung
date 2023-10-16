package org.example.frontend;

import org.example.backend.presentationlayer.UserController;
import org.example.entity.User;
import org.example.utils.ScannerUtils;

import java.sql.SQLException;
import java.util.List;

public class Function {
    private UserController userController = new UserController();

    public void question2() throws SQLException {
        System.out.println("Nhập vào ID  Project bạn muốn kiểm tra!!");
        int id = ScannerUtils.inputInt("Bạn phải nhập vào số nguyên!!");
        List<User> list = userController.getUser(id);
        System.out.println("*********************************************************");
        System.out.println("*  ID  *          Họ và tên           *      ROLE       *");
        System.out.println("*********************************************************");
        for (User i: list) {
            System.out.printf("*  %-4d*       %-23s*     %-12s*%n", i.getId(), i.getName(), i.getRole());
        }
        System.out.println("******************************************************");
    }

    public void question3() throws SQLException {
        System.out.println("Nhập email");
        String email = ScannerUtils.inputEmail();
        System.out.println("Nhập password");
        String password = ScannerUtils.inputPassword();
        List<User> list = userController.getLogin(email, password);

        if (list.size() > 0) {
            System.out.println("**********************************************************************");
            System.out.println("*  ID  *          Họ và tên           *      ROLE       *   Project  *");
            System.out.println("**********************************************************************");
            for (User i : list) {
                System.out.printf("*  %-4d*       %-23s*     %-12s*   %-9d*%n", i.getId(), i.getName(), i.getRole(), i.getProjectID());
            }
            System.out.println("**********************************************************************");
            System.out.println("Đăng nhập thành công !!");
        }
        else System.out.println("Tài khoản không tồn tại hoặc bạn không có quyền truy cập vào tài khoản ADMIN!! ");
    }

    public void question4() throws SQLException{
        System.out.println("Nhập họ tên đăng ký!!");
        String fullName = ScannerUtils.inputName("Bạn hãy nhập đúng chuẩn họ tên, không chứa ký tự đặc biệt !! VD: Ngo Tuan Hung");
        System.out.println("Nhập email");
        String email = ScannerUtils.inputEmail();
        userController.createNewUser(fullName, email);
    }
}

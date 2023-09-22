package org.example.frontend;

import org.example.backend.presentationlayer.UserController;
import org.example.entity.User;
import org.example.utils.ScannerUtils;

import java.sql.SQLException;
import java.util.List;

public class Function {
    private UserController userController = new UserController();

    public void question1(int id) throws SQLException {
        List<User> list = userController.getUser(id);
        System.out.println("******************************************************");
        System.out.println("*  ID  *          Họ và tên        *      ROLE       *");
        System.out.println("******************************************************");
        for (User i: list) {
            System.out.printf("*  %-4d* %-26s* %-16s*%n", i.getId(), i.getName(), i.getRole());
        }
        System.out.println("******************************************************");
    }

    public void question2() throws SQLException {
        List<User> list = userController.getManager();
        System.out.println("*******************************************************************");
        System.out.println("*  ID  *          Họ và tên        *      ROLE       *   Project  *");
        System.out.println("*******************************************************************");
        for (User i: list) {
            System.out.printf("*  %-4d* %-26s*     %-12s*   %-9d*%n", i.getId(), i.getName(), i.getRole(), i.getProjectID());
        }
        System.out.println("*******************************************************************");
    }

    public void question3() throws SQLException {
        System.out.println("Nhập email");
        String email = ScannerUtils.inputEmail();
        System.out.println("Nhập password");
        String password = ScannerUtils.inputPassword();
        List<User> list = userController.getLogin(email, password);

        if (list.size() > 0) {
            System.out.println("*******************************************************************");
            System.out.println("*  ID  *          Họ và tên        *      ROLE       *   Project  *");
            System.out.println("*******************************************************************");
            for (User i : list) {
                System.out.printf("*  %-4d* %-26s*     %-12s*   %-9d*%n", i.getId(), i.getName(), i.getRole(), i.getProjectID());
            }
            System.out.println("*******************************************************************");
            System.out.println("Đăng nhập thành công !!");
        }
        else System.out.println("Tài khoản không tồn tại !!");
    }
}

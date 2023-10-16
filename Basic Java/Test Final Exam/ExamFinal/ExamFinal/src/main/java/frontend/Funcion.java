package frontend;

import backend.controller.Controller;
import entity.User;
import utils.ScanerUtils;

import java.util.List;

public class Funcion {

    private Controller controller;
    public Funcion (){
        controller = new Controller();
    }
public void getByProjectId(){
    System.out.println("Mời nhập vào ProjectID: ");
    int id = ScanerUtils.inputNumber();
    List<User> userList = controller.getByProjectId(id);

    String leftAlignFormat = "| %-3s| %-18s | %-21s | %-14s |%n";
    System.out.format("+----+--------------------+------------------------+-----------------+%n");
    System.out.format("| id |     fullName       |       email            |        role     |%n");
    System.out.format("+----+--------------------+------------------------+-----------------+%n");
    for (User user:userList
         ) {
        System.out.printf(leftAlignFormat,user.getId(),user.getFullname(),user.getEmail(),user.getRole().name());
    }
    System.out.format("+----+--------------------+------------------------+-----------------+%n");

}

    public void getManagerOfProject(){
        System.out.println("Mời nhập vào ProjectID: ");
        int id = ScanerUtils.inputNumber();
        List<User> userList = controller.getManagerOfProject(id);

        String leftAlignFormat = "| %-3s| %-18s | %-21s | %-14s |%n";
        System.out.format("+----+--------------------+------------------------+-----------------+%n");
        System.out.format("| id |     fullName       |       email            |        role     |%n");
        System.out.format("+----+--------------------+------------------------+-----------------+%n");
        for (User user:userList
        ) {
            System.out.printf(leftAlignFormat,user.getId(),user.getFullname(),user.getEmail(),user.getRole().name());
        }
        System.out.format("+----+--------------------+------------------------+-----------------+%n");

    }

    public void login(){
        try {
            System.out.println("Mời nhập vào email: ");
            String email = ScanerUtils.inputEmail();

            System.out.println("Mời nhập vào password: ");
            String pass = ScanerUtils.inputPassword();
            User user = controller.login(email,pass);

            String leftAlignFormat = "| %-3s| %-18s | %-21s | %-14s |%n";
            System.out.format("+----+--------------------+------------------------+-----------------+%n");
            System.out.format("| id |     fullName       |       email            |        role     |%n");
            System.out.format("+----+--------------------+------------------------+-----------------+%n");

            System.out.printf(leftAlignFormat,user.getId(),user.getFullname(),user.getEmail(),user.getRole().name());

            System.out.format("+----+--------------------+------------------------+-----------------+%n");
        }catch (Exception e){
            System.out.println("Có lỗi xảy ra khi đăng nhập vui lòng kiểm tra lại email, password!");

        }


    }

}

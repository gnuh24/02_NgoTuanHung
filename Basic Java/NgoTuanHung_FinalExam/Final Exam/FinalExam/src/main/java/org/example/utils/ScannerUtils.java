package org.example.utils;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ScannerUtils {
    public static String inputEmail() {
        Scanner input = new Scanner(System.in);
        try {
            String value = input.nextLine();
            if (!value.contains("@")){
                throw new Exception("Email của bạn phải bao gồm @");
            }
            return value;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return inputEmail();
    }
    public static String inputPassword() {
        Scanner input = new Scanner(System.in);
        try {
            String value = input.nextLine();
            if (value.length() < 6 || value.length() > 12){
                throw new Exception("Password của bạn chỉ được có từ 6 -> 12 ký tự");
            }
            return value;
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return inputPassword();
    }
    public static int inputInt(String message) {
        Scanner input = new Scanner(System.in);
        try {
            int value = Integer.parseInt(input.nextLine());
            return value;
        }
        catch (Exception e) {
            System.out.println(message);
        }
        return inputInt(message);
    }

    public static String inputName(String message){
        Scanner input = new Scanner(System.in);
        try{
            String name = input.nextLine();
            // Định nghĩa biểu thức chính quy để tìm các ký tự đặc biệt trong chuỗi
            String regex = "[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]+";

            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);

            if (matcher.find()) {
                do {
                    String specialChar = matcher.group();
                    System.out.print(specialChar + " ");
                } while (matcher.find());
                throw new Exception("Chuỗi không được chứa các ký tự đặc biệt như thế !!");
            }
            return name;
        }
        catch (Exception e){
            System.out.println(e.getMessage());

            System.out.println(message);
        }
        return inputName(message);
    }

}

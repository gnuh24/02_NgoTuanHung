package org.example.utils;

import java.util.Scanner;

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

    public static float inputFloat(String message){
        Scanner input = new Scanner(System.in);
        try{
            return Float.parseFloat( input.nextLine() );
        }
        catch (Exception e){
            System.out.println(message);
        }
        return inputFloat(message);
    }
    public static double inputDouble(String message){
        Scanner input = new Scanner(System.in);
        try{
            return Double.parseDouble( input.nextLine() );
        }
        catch (Exception e){
            System.out.println(message);
        }
        return inputDouble(message);
    }

    public static String inputString(String message){
        Scanner input = new Scanner(System.in);
        try{
            return  input.nextLine() ;
        }
        catch (Exception e){
            System.out.println(message);
        }
        return inputString(message);
    }

}

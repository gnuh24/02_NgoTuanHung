package utils;

import java.util.Scanner;

public class ScanerUtils {

    static Scanner scanner = new Scanner(System.in);
    public static String inputString(){
        return scanner.nextLine();
    }
    public static int inputNumber(){
        int number = 0;
        while (true){
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number<0){
                    System.err.println("Ban phai nhap so lon hon 0");
                    continue;
                }break;
            }catch (NumberFormatException ex){
                System.err.println("Khong phai la 1 so. Moi nhap lai");
            }
        }return number;
    }
    public static int inputNumber( int min, int max){
        int number = 0;
        while (true) {
            try {
                number = Integer.parseInt(scanner.nextLine());
                if (number < min || number > max) {
                    System.err.println("So nhap vao khong dung");
                    continue;
                }
                break;
            } catch (NumberFormatException ex) {
                System.out.println("So nhap vao khong dung. Moi nhap lai");
            }
        }
        return number;

    }
    public static String inputEmail(){
        String email = scanner.nextLine();
        while (!email.contains("@")){
            System.err.println("Dinh dang cua email khong dung");
            email=scanner.nextLine();
        }
        return email;
    }
    public static String inputPassword(){
        while (true){
            String input = inputString();
            int length = input.length();
            if (length<6 || length>12 ){
                System.err.println("Mat khau phai & den 12 ki tu");
                System.out.println("Moi nhap lai mat khau");
            }return input;
        }

    }
}

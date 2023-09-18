package org.example.utils;

import java.util.Scanner;

public class ScannerUtils {
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

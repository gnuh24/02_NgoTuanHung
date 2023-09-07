package org.example.entity;

import java.util.Scanner;

public class ScannerUtils {
    Scanner input = new Scanner(System.in);
    public int inputInt(String errorMessage){
        try {
            return Integer.parseInt(input.nextLine());
        }
        catch (Exception e){
            System.out.println(errorMessage);
        }
        return inputInt("");
    }




    public float inputFloat(String errorMessage){
        try {
            return Float.parseFloat( input.nextLine() );
        }
        catch (Exception e){
            System.out.println("wrong inputing! Please input an age as float, input again");
        }
        return inputFloat("");
    }

    public double inputDouble(String errorMessage){
        try {
            return  input.nextDouble();
        }
        catch (Exception e){
            System.out.println("wrong inputing! Please input an age as Double, input again");
        }
        return inputDouble("");
    }

    public String inputString(String errorMessage){
        return input.next();
    }

}

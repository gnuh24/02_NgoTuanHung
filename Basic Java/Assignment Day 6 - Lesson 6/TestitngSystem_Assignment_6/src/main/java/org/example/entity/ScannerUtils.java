package org.example.entity;

import java.util.Scanner;

public class ScannerUtils {
    Scanner in = new Scanner(System.in);

    public int inputInt(String errorMessage){
        try {

            //return in.nextInt();
            return Integer.parseInt(in.nextLine());

        }
        catch (Exception e) {
            System.out.println(errorMessage);
        }
        return inputInt(errorMessage);
    }




    public float inputFloat(String errorMessage){
        try {
            return Float.parseFloat( in.nextLine() );
        }
        catch (Exception e){
            System.out.println("wrong inputing! Please input an age as float, input again");
        }
        return inputFloat("");
    }

    public double inputDouble(String errorMessage){
        try {
            return  in.nextDouble();
        }
        catch (Exception e){
            System.out.println("wrong inputing! Please input an age as Double, input again");
        }
        return inputDouble("");
    }

    public String inputString(String errorMessage){
        return in.next();
    }

}

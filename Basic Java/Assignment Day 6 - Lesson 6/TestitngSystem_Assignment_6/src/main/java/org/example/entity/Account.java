package org.example.entity;

import java.util.Scanner;

public class Account {
    private int id;
    private String name;

    public Account(){
        ScannerUtils test = new ScannerUtils();
        this.id = test.inputInt("");
        this.name = test.inputString("");
    }



    public int inputAge(){
        Scanner input = new Scanner(System.in);
        try {
            int a =  Integer.parseInt( input.nextLine() );
            if ( a <= 0)
                throw new InvalidAgeInputingException("Your age must be greater than 0");
            return a;
        }

        catch (InvalidAgeInputingException e){
            System.out.println(e.getMessage());
        }
        return inputAge();
    }
}

class InvalidAgeInputingException extends Exception{
    public InvalidAgeInputingException(String i){

        super(i);
    }
}

package org.example;

import java.util.Scanner;

public class Exercise2 {
    public void question1(String name){
        String [] list = name.split(" ");
        System.out.print(list[0] + " ");
        for (int i=1; i< list.length; i++)
            System.out.print( list[i].toUpperCase() + " " );
    }

    public int question2(String name){
        int count = 0;
        for (int i=0; i< name.length(); i++){
            if ( name.charAt(i) == 'a' || name.charAt(i) == 'A' )
                count++;
        }
        return count;
    }
    public void question3(String name, Character oldChar, Character newChar){
        System.out.println(name.replace(oldChar, newChar));
    }
    public void question4(String name){
        StringBuffer name1 = new StringBuffer(name);
        System.out.println(name1.reverse());
    }
    int count(String test, Character charTest){
        int count = 0;
        for (int i=0; i< test.length(); i++){
            if ( test.charAt(i) == charTest )
                count++;
        }
        return count;
    }
    public void question5(String name){
        for (int i=0; i<10; i++){
            System.out.println(i + " - " + count(name, Integer.toString(i).charAt(0) ) );
        }
    }
    public void question6(String name){
        String [] newList = name.split(" ");
        int j = 0;
        for(String i: newList) {
            System.out.println("a[" + (j++) + "] = " + i);
        }
    }
    public void question7(){
        Scanner input = new Scanner(System.in);
        String password = "asdfghjkl", username = "qwertyuiop";
        String newPasswrod, newUsername;
        do {
            System.out.println("Tên tài khoảng ^^");
            newUsername = input.next();
        } while ( !newUsername.equals(username));

        do {
            System.out.println("Nhập mật khẩu ^^");
            newPasswrod = input.next();
        } while ( !newPasswrod.equals(password) );
    }

}

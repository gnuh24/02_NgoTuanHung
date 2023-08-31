package org.example.backend;

import java.util.Scanner;

public class Exercise2 {
    public float question1(int a, int b) throws Exception {
        if (b == 0)
            throw new Exception("Cannot Divide 0");
        return (float) a / b;
    }


    public void question3() throws  Exception{
        int [] list = {1, 2, 3};
        try {
            System.out.println(list[10]);
        }
        catch (Exception e){
            throw  new Exception("Lỗi nè ^^");
        }
    }


    public int getIndex(int [] list, int index) throws Exception{
        if (index >= list.length)
            throw new Exception("Cannot find Department!!");
        return list[index];
    }

    public class MyError extends Exception{
        public MyError(String i){
            super(i);
        }
    }
    public int inputAge() {
        Scanner input = new Scanner(System.in);

        try {
            int a = Integer.parseInt(input.nextLine());
            if (a < 0 || a > 10 ) {
                throw new MyError("Wrong inputing! The age must be greater than 0, please input again.");
            }
            return a;
        }

        catch (NumberFormatException e) {
            System.out.println("wrong inputing! Please input an age as int, input again");
        }

        catch (MyError e){
            System.out.println("Wrong inputing! The age must be greater than 0, please input again.");
        }

        System.out.println("Nhập lại ^^");
        return inputAge();
    }



}

package org.example;
import java.util.Random;
import java.util.Scanner;

public class Exercise_1 {
    public static void question1(){
        Account account1 = new Account(5240.5);
        Account account2 = new Account(10970.055);
        int a = (int) account1.salary;
        int b = (int) account2.salary;
        System.out.println(a);
        System.out.println(b);
    }

    public static String question2(){
        Random random = new Random();
        int a = random.nextInt(100000) ;
        String b;
        if (a > 9999)
            b = Integer.toString(a);
        else {
            byte count = 0;
            int temp = a;
            while (temp > 0){
                count++;
                temp /= 10;
            }
            b = Integer.toString(a);

            if (b.equals("0"))
                for (int i=1; i<= 4; i++)
                    b = "0".concat(b);

            else
                for (int i=1; i<= 5-count; i++)
                    b = "0".concat(b);
            }
        return b;
    }

    public static void question3(){
        int a = Integer.parseInt( Exercise_1.question2() );
        System.out.println(a % 100);
    }

    public static void question4(){
        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b;
        do {
            b = input.nextInt();
        } while(b == 0);
        System.out.println( (float) a/b);
        input.close();
    }
}
class Account {
   double salary;
   public  Account(double salary){
       this.salary = salary;
   }


}

package org.example;

import java.util.Date;


public class Exercise_2 {

    public static void question1(){
        NewAccount account1 = new NewAccount();
        NewAccount account2 = new NewAccount();
        NewAccount account3 = new NewAccount();
        NewAccount account4 = new NewAccount();
        NewAccount account5 = new NewAccount();

        NewAccount [] list = {account1, account2, account3, account4, account5};


        for (int i=0;i < 5; i++){
            list[i].email = "Email " + i;
            list[i].username = "Username " + i;
            list[i].fullname = "Fullname " + i;
            list[i].createDate = new Date();
        }
    }
}
class NewAccount{
    String email;
    String username;
    String fullname;
    Date createDate;

}

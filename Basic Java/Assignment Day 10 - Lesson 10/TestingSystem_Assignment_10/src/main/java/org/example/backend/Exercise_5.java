package org.example.backend;

import java.sql.Connection;
import java.sql.DriverManager;

public class Exercise_5 {
    public static boolean isConnectedForTesting(String url, String user , String pass) throws Exception{
        Connection connection = DriverManager.getConnection(url, user, pass);

        if (connection != null) {
            System.out.println("Connect success!");
            return true;
        }

        else {
            System.out.println("Connect fail!");
            return false;
        }
    }



}

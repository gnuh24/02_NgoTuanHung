package org.example.frontend;

import org.example.backend.Exercise_1;
import org.example.backend.Exercise_3;
import org.example.backend.Exercise_5;

import java.sql.Connection;

public class Program5 {
    public static void main(String [] agrs) {

        String dbUrl = "jdbc:mysql://localhost:3306/testing_system_assignment_1";
        String user = "root";
        String pass = "0204";
        try{
            Exercise_5.isConnectedForTesting(dbUrl, user, pass);

        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

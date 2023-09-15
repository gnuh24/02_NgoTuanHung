package org.example.frontend;

import org.example.backend.Exercise_1;
import org.example.backend.Exercise_3;
import org.example.entity.Department;

import java.sql.Connection;
import java.util.List;

public class Program3 {
    public static void main(String [] agrs) {

        String dbUrl = "jdbc:mysql://localhost:3306/testing_system_assignment_1";
        String user = "root";
        String pass = "0204";
        Connection connection = Exercise_1.question_1(dbUrl, user, pass);
        try{
            Exercise_3.deleteDepartmentUsingProcedure(connection, 12);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

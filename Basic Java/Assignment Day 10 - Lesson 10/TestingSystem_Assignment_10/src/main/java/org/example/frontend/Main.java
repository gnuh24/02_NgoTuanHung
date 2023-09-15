package org.example.frontend;

import org.example.backend.Exercise_1;

import java.sql.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/testing_system_assignment_1";
        String user = "root";
        String pass = "0204";

        String queryQuestion2 = " SELECT * FROM `Position`; ";

        String queryQuestion3 = " INSERT INTO `position`(`PositionName`)\n" +
                                "VALUES (?); ";

        String queryQuestion4 = " UPDATE `position`\n" +
                                "SET `PositionName` = ?\n" +
                                "WHERE `PositionID` = ?; ";

        String queryQuestion5 = " DELETE FROM `position`\n" +
                                " WHERE `PositionID` = ?;";
        Connection connection = Exercise_1.question_1(dbUrl,user,pass);
        Exercise_1.question_2(connection, queryQuestion2);

        Exercise_1.question_3(connection, queryQuestion3, "Test");
        Exercise_1.question_2(connection, queryQuestion2);

        Exercise_1.question_4(connection, queryQuestion4, 7, "Dev");
        Exercise_1.question_2(connection, queryQuestion2);

        Exercise_1.question_5(connection, queryQuestion5, 7);
        Exercise_1.question_2(connection, queryQuestion2);

        try{
            connection.close();
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
}
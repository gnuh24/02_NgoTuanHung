package org.example.backend;
import java.sql.*;

public class Exercise_1 {
    public static Connection question_1(String url, String user , String pass){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, pass);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        if (connection != null)
                System.out.println("Connect success!");
        else    System.out.println("Connect fail!");

        return connection;
    }

    public static void question_2(Connection connection, String query){
        Statement statement;
        ResultSet resultSet;
        try{
            statement = connection.createStatement();
            resultSet = statement.executeQuery(query);
            System.out.printf("%-10s | %-30s%n", "PositionID", "PositionName");
            while (resultSet.next())
                System.out.printf("%-10d | %-30s%n", resultSet.getInt(1), resultSet.getString(2));
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public static void question_3(Connection connection, String query, String newPositionName){
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(query);

            preparedStatement.setString(1, newPositionName);
            if (preparedStatement.executeUpdate() > 0)
                    System.out.println("Create Position "+ newPositionName +" success !!");
            else    System.out.println("Create Position "+ newPositionName +" fail !!");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Create Position "+ newPositionName +" fail !!");
        }
    }

    public static void question_4(Connection connection, String query, int id,String newPositionName){
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, newPositionName);
            preparedStatement.setInt(2, id);
            if (preparedStatement.executeUpdate() > 0)
                System.out.println("Change Position success !!");
            else    System.out.println("Change Position fail !!");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Change Position fail !!");
        }
    }

    public static void question_5(Connection connection, String query, int id){
        PreparedStatement preparedStatement;
        try{
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            if (preparedStatement.executeUpdate() > 0)
                System.out.println("Delete Position success !!");
            else    System.out.println("Delete Position fail !!");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
            System.out.println("Delete Position fail !!");
        }
    }



}

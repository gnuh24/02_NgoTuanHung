package org.example.backend;

import org.example.entity.Department;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;

public class DepartmentDao {
    public static List<Department> getDepartment (Connection connection) throws Exception{
        String query = "SELECT * FROM `Department`";
        List<Department> result = new ArrayList<>();
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery(query);
        while (resultSet.next()){
            result.add(new Department(resultSet.getInt(1), resultSet.getString(2)));
        }
        return result;
    }

    public static void getDepartmentById(Connection connection, int id) throws Exception{
        String query= "SELECT * FROM `Department` WHERE `DepartmentID` = ?;";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (!resultSet.next())
            System.out.println("Cannot find department which has id = " + id);
        else {
            do{
                System.out.println(resultSet.getInt(1) + " " + resultSet.getString(2));
            } while ( resultSet.next() );
        }
    }

    public static boolean isDepartmentNameExists(Connection connection, String name) throws Exception{
        String query = "SELECT * FROM `Department` WHERE `DepartmentName` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }

    public static void createDepartment ( Connection connection, String name) throws Exception{
        String query = "INSERT INTO `Department`(`DepartmentName`) VALUES (?)";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, name);
        if ( preparedStatement.executeUpdate() > 0)
            System.out.println("Create success!!");
        else System.out.println("Create fail!!");
    }

    public static boolean isDepartmentIDExists(Connection connection, int id) throws Exception{
        String query = "SELECT * FROM `Department` WHERE `DepartmentID` = ?";
        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        return resultSet.next();
    }
    public  static  void updateDepartmentName(Connection connection,int id, String newName) throws Exception{
        String query = "UPDATE `Department` SET `DepartmentName` = ? WHERE `DepartmentID` = ?";
        if (!DepartmentDao.isDepartmentIDExists(connection, id))
            throw new Exception("Cannot find department which has id = " + id);
        else {
            if (DepartmentDao.isDepartmentNameExists(connection, newName))
                throw new Exception("Department Name is Exists!");
        }

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setString(1, newName);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    }

    public static void deleteDepartment (Connection connection, int id) throws Exception{
        String query = "DELETE FROM `Department WHERE `DepartmentID` = ?";
        if (!DepartmentDao.isDepartmentIDExists(connection, id))
            throw new Exception("Cannot find department which has id = " + id);

        PreparedStatement preparedStatement = connection.prepareStatement(query);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }
}

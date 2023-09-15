package org.example.backend;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exercise_4 {
    public static void deleteDepartment (Connection connection, int id) {
        Scanner input = new Scanner(System.in);
        try{
            String query = "DELETE FROM `Account` WHERE `DepartmentID` = ?";
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();

            String query2 = "DELETE FROM `Department` WHERE `DepartmentID` = ?";
            if (!DepartmentDao.isDepartmentIDExists(connection, id))
                throw new Exception("Cannot find department which has id = " + id);
            PreparedStatement preparedStatement2 = connection.prepareStatement(query2);
            preparedStatement2.setInt(1, id);
            preparedStatement2.executeUpdate();

            System.out.println("Bạn có muốn thay đổi dữ liệu ? (1/0)");
            int choice = input.nextInt();
            if (choice == 1)
                connection.commit();
            else connection.rollback();


        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
                input.close();
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }

        }

    }
}

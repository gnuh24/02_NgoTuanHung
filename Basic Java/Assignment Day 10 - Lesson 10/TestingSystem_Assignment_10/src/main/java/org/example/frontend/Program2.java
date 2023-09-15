package org.example.frontend;

import org.example.backend.DepartmentDao;
import org.example.backend.Exercise_1;
import org.example.entity.Department;

import java.sql.Connection;
import java.util.List;
public class Program2
{
    public static void main(String [] agrs){
        String dbUrl = "jdbc:mysql://localhost:3306/testing_system_assignment_1";
        String user = "root";
        String pass = "0204";
        List<Department> listDepartment = null;
        Connection connection = Exercise_1.question_1(dbUrl, user, pass);
        try{
            //listDepartment = DepartmentDao.getDepartment(connection);
            //System.out.println(listDepartment);
            //DepartmentDao.getDepartmentById(connection, 11);
            //System.out.println(DepartmentDao.isDepartmentNameExists(connection, "IT"));
            //DepartmentDao.createDepartment(connection, "Fuho");
            //DepartmentDao.updateDepartmentName(connection, 11, "Fuho");
            //DepartmentDao.deleteDepartment(connection, 13);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}

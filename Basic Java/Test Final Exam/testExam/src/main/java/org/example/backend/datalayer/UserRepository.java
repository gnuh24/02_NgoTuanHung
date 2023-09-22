package org.example.backend.datalayer;

import org.example.entity.Role;
import org.example.entity.User;
import org.example.utils.JDBCUtils;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepository implements IUserRepository{
    public List<User> getUser(int idProject) throws SQLException {
        List<User> result = new ArrayList<>();
        JDBCUtils jdbcUtils = new JDBCUtils();
        JDBCUtils.getConnection();
        String query = "SELECT * FROM User \n" +
                "WHERE projectid = ?\n" +
                "ORDER BY `role`;";
        PreparedStatement preparedStatement = JDBCUtils.connection.prepareStatement(query);
        preparedStatement.setInt(1,idProject);
        if (preparedStatement.execute()){
            System.out.println("Lấy danh sách thành công !!");
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String pass = resultSet.getString(4);
                int exp = resultSet.getInt(5);
                String proSkill = resultSet.getString(6);
                int idP = resultSet.getInt(7);
                String stringRole = resultSet.getString(8);
                Role role = Role.valueOf(stringRole);
                result.add( new User(id, name, email, pass, exp, proSkill,idP, role)  );
            }
        }
        else System.out.println("Lấy danh sách thất bại !!");
        JDBCUtils.closeConnection();
        return result ;
    }
    public List<User> getManager() throws SQLException {
        List<User> result = new ArrayList<>();
        JDBCUtils jdbcUtils = new JDBCUtils();
        JDBCUtils.getConnection();
        String query = "SELECT * FROM User \n" +
                "WHERE role = \"MANAGER\"" +
                "ORDER BY id;";
        Statement statement = JDBCUtils.connection.createStatement();
        if (statement.execute(query)){
            System.out.println("Lấy danh sách thành công !!");
            ResultSet resultSet = statement.getResultSet();
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String pass = resultSet.getString(4);
                int exp = resultSet.getInt(5);
                String proSkill = resultSet.getString(6);
                int idP = resultSet.getInt(7);
                String stringRole = resultSet.getString(8);
                Role role = Role.valueOf(stringRole);
                result.add( new User(id, name, email, pass, exp, proSkill,idP, role)  );
            }
        }
        else System.out.println("Lấy danh sách thất bại !!");
        JDBCUtils.closeConnection();
        return result ;
    }

    public List<User> getLogin(String inputEmail, String inputPassword) throws SQLException {
        List<User> result = new ArrayList<>();
        JDBCUtils jdbcUtils = new JDBCUtils();
        JDBCUtils.getConnection();
        String query = "SELECT * FROM User\n" +
                "WHERE email = ? AND password = ?;";
        PreparedStatement preparedStatement = JDBCUtils.connection.prepareStatement(query);
        preparedStatement.setString(1, inputEmail);
        preparedStatement.setString(2, inputPassword);

        if (preparedStatement.execute()) {
            System.out.println("Lấy danh sách thành công !!");
            ResultSet resultSet = preparedStatement.getResultSet();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                String email = resultSet.getString(3);
                String pass = resultSet.getString(4);
                int exp = resultSet.getInt(5);
                String proSkill = resultSet.getString(6);
                int idP = resultSet.getInt(7);
                String stringRole = resultSet.getString(8);
                Role role = Role.valueOf(stringRole);
                result.add(new User(id, name, email, pass, exp, proSkill, idP, role));
            }
        } else System.out.println("Lấy danh sách thất bại !!");
        JDBCUtils.closeConnection();
        return result;


    }

}

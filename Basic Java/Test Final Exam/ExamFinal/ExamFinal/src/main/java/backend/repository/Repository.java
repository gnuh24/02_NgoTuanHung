package backend.repository;

import entity.Role;
import entity.User;
import utils.JDBCutils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Repository implements IRepository {
    private JDBCutils jdbCutils;

    public Repository() {
        jdbCutils = new JDBCutils();
    }

    @Override
    public List<User> getByProjectId(int projectId) {

        String sql = "SELECT * FROM `user` WHERE ProjectId = ?";
        Connection connection = jdbCutils.getConnection();
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fullname = resultSet.getString(2);
                String email = resultSet.getString(3);
                String pass = resultSet.getString(4);
//                int exp = resultSet.getInt(6);
//                String proSkill = resultSet.getString(7);

                String roleDB = resultSet.getString(8);
                Role roleEntity = Role.valueOf(roleDB);

                User user = new User(id, fullname, email, pass, projectId, roleEntity);

                userList.add(user);
            }


        } catch (Exception e) {
            System.err.println("Có lỗi xảy ra!");
        } finally {
            jdbCutils.closeConnection();
        }


        return userList;
    }

    @Override
    public List<User> getManagerOfProject(int projectId) {
        String sql = "SELECT * FROM `user` WHERE ProjectId = ? and `role` = 'MANAGER'";
        Connection connection = jdbCutils.getConnection();
        List<User> userList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, projectId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fullname = resultSet.getString(2);
                String email = resultSet.getString(3);
                String pass = resultSet.getString(4);
//                int exp = resultSet.getInt(6);
//                String proSkill = resultSet.getString(7);

                String roleDB = resultSet.getString(8);
                Role roleEntity = Role.valueOf(roleDB);

                User user = new User(id, fullname, email, pass, projectId, roleEntity);

                userList.add(user);
            }


        } catch (Exception e) {
            System.err.println("Có lỗi xảy ra!");
        } finally {
            jdbCutils.closeConnection();
        }


        return userList;
    }

    @Override
    public User login(String email, String password) {
        try {
            String sql = "SELECT * FROM `user` WHERE email = ? AND `password` = ?";

            Connection connection = jdbCutils.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String fullname = resultSet.getString(2);
                String emailDB = resultSet.getString(3);
                String passDB = resultSet.getString(4);
                int projectId = resultSet.getInt(5);
//                int exp = resultSet.getInt(6);
//                String proSkill = resultSet.getString(7);

                String roleDB = resultSet.getString(8);
                Role roleEntity = Role.valueOf(roleDB);

                User user = new User(id, fullname, emailDB, passDB, projectId, roleEntity);
                return user;
            }
        } catch (Exception e) {
            System.out.println("Lỗi");
        } finally {
            jdbCutils.closeConnection();
        }
        return null;
    }
}

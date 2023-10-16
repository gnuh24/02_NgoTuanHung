package org.example.backend.presentationlayer;

import org.example.backend.businesslayer.UserService;
import org.example.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserController {
    UserService userService = new UserService();
    public List<User> getUser(int idProject) throws SQLException {
        return userService.getUser(idProject);
    }
    public List<User> getLogin(String email, String password) throws SQLException{
        return userService.getLogin(email, password);
    }

    public void createNewUser(String fullname, String email) throws SQLException {
        userService.createNewUser(fullname, email);
    }
}

package org.example.backend.businesslayer;

import org.example.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserService {
    public List<User> getUser(int idProject) throws SQLException;
    public List<User> getLogin(String email, String password) throws SQLException;
    public void createNewUser(String fullname, String email) throws SQLException;

}

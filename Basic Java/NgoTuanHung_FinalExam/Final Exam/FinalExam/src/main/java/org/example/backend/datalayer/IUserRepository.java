package org.example.backend.datalayer;

import org.example.entity.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    public List<User> getUser(int idProject) throws SQLException;
    public List<User> getLogin(String email, String password) throws SQLException;
    public void createNewUser(String fullname, String email) throws SQLException;

    }

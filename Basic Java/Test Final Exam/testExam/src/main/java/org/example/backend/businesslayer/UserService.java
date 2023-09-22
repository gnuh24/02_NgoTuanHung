package org.example.backend.businesslayer;

import org.example.backend.datalayer.UserRepository;
import org.example.entity.User;

import java.sql.SQLException;
import java.util.List;

public class UserService implements IUserService{
    UserRepository userRepository = new UserRepository();
    public List<User> getUser(int idProject) throws SQLException{
        return userRepository.getUser(idProject);
    }
    public List<User> getManager() throws SQLException{
        return userRepository.getManager();
    }

    public List<User> getLogin(String email, String password) throws  SQLException{
        return userRepository.getLogin(email, password);
    }
}

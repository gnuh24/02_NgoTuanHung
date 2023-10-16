package backend.service;

import entity.User;

import java.util.List;

public interface IService {
    List<User> getByProjectId(int projectId);

    List<User> getManagerOfProject(int projectId);

    User login(String email, String password);
}

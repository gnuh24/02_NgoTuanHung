package backend.repository;

import entity.User;

import java.util.List;

public interface IRepository {
    List<User> getByProjectId( int projectId);

    List<User> getManagerOfProject(int projectId);

    User login(String email, String password);
}

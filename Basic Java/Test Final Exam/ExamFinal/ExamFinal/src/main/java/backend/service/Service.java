package backend.service;

import backend.repository.IRepository;
import backend.repository.Repository;
import entity.User;

import java.util.List;

public class Service implements IService{
    private IRepository repository;

    public Service(){
        repository = new Repository();
    }

    @Override
    public List<User> getByProjectId(int projectId) {
        return repository.getByProjectId(projectId);
    }

    @Override
    public List<User> getManagerOfProject(int projectId) {
        return repository.getManagerOfProject(projectId);
    }

    @Override
    public User login(String email, String password) {
        return repository.login(email,password);
    }
}

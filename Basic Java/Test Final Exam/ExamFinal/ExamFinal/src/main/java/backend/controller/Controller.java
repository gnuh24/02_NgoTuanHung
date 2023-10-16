package backend.controller;

import backend.service.IService;
import backend.service.Service;
import entity.User;

import java.util.List;

public class Controller {
    private IService service;

    public Controller() {
        service = new Service();
    }

    public List<User> getByProjectId(int projectId) {
        return service.getByProjectId(projectId);
    }

    public List<User> getManagerOfProject(int projectId) {
        return service.getManagerOfProject(projectId);
    }
    public User login(String email, String password) {
        return service.login(email,password);
    }
}

package com.vti.TestingSystemAssignment7.Service;

import com.vti.TestingSystemAssignment7.Entity.Department;
import com.vti.TestingSystemAssignment7.Repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;

import java.util.List;

@Service
public class DepartmentService implements IDepartmentService {

    @Autowired
    private IDepartmentRepository repository;

    public Page<Department> getAllDepartment(Pageable pageable){

        return  repository.findAll(pageable);
    }

    public List<Department> getAllDepartment(){
        return repository.findAll();
    }

    public Department getDepartmentByID(short id){
        return repository.findById( (int) id).get();
    }

    public Department getDertpartByName (String name){
        return repository.findByName(name);
    }

    public void createDepartment (Department department){
        repository.save(department);
    }

    public void updateDepartment (Department department){
        repository.save(department);
    }

    public void updateDepartment(short id, String name){
        Department department = new Department(name);
        department.setId(id);
        repository.save(department);
    }

    public void deleteDepartment(short id){
        repository.deleteById( (int) id);
    }

    public boolean isDepartmentExistsByID(short id){
        Department department = getDepartmentByID(id);
        return department != null;
    }

    public boolean isDepartmentExistsByName(String name){
        Department department = getDertpartByName(name);
        return department != null;
    }

}

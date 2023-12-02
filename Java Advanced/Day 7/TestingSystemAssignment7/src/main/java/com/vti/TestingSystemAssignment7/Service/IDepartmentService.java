package com.vti.TestingSystemAssignment7.Service;

import com.vti.TestingSystemAssignment7.Entity.Department;
import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import java.util.List;

public interface IDepartmentService {
    public List<Department> getAllDepartment();

    public Page<Department> getAllDepartment(Pageable pageable);
    public Department getDepartmentByID(short id);
    public Department getDertpartByName (String name);

    public void createDepartment (Department department);

    public void updateDepartment (Department department);

    public void updateDepartment(short id, String name);

    public void deleteDepartment(short id);

    public boolean isDepartmentExistsByID(short id);

    public boolean isDepartmentExistsByName(String name);

}

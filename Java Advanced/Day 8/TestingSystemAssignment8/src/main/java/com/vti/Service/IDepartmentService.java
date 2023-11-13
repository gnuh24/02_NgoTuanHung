package com.vti.Service;

import com.vti.Entity.Department;
import com.vti.Filler.DepartmentFillerForm;
import com.vti.Form.CreatingDepartmentForm;
import com.vti.Form.UpdateDepartmentForm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IDepartmentService    {
    public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFillerForm form);

    public Department getDepartmentByName(String name);

    public Department getDepartmentById(int id);

    public void createDepartment(CreatingDepartmentForm form);

    public void updateDepartment(UpdateDepartmentForm form);

    }

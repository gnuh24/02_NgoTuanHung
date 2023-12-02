package com.vti.service;

import java.util.List;

import com.vti.entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IDepartmentService {

	public List<Department> getAllDepartments();

	public Department getDepartmentByID(int id);

	public void createDepartment(Department department);

	public void updateDepartment(Department department);

	public void deleteDepartment(int id);

	public boolean isDepartmentExistsByID(int id);

	public Department getDepartmentByName(String name);

	public Page<Department> getAllDepartmentByPage(Pageable pageable);
}




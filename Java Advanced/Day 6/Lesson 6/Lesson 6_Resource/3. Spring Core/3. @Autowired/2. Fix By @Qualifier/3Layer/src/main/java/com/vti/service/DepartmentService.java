package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	@Qualifier("DepartmentRepo-V2")
	private IDepartmentRepository repository;

	public List<Department> getAllDepartments() {
		return repository.getAllDepartments();
	}

	public Department getDepartmentByID(int id) {
		return repository.getDepartmentByID(id);
	}

	public Department getDepartmentByName(String name) {
		return repository.getDepartmentByName(name);
	}

	public void createDepartment(Department department) {
		repository.createDepartment(department);
	}

	public void updateDepartment(int id, String newName) {
		repository.updateDepartment(id, newName);
	}

	public void updateDepartment(Department department) {
		repository.updateDepartment(department);
	}

	public void deleteDepartment(int id) {
		repository.deleteDepartment(id);
	}

	public boolean isDepartmentExistsByID(int id) {
		return repository.isDepartmentExistsByID(id);
	}

	public boolean isDepartmentExistsByName(String name) {
		return repository.isDepartmentExistsByName(name);
	}
}

package com.vti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.vti.entity.Department;
import com.vti.repository.IDepartmentRepository;

@Service
public class DepartmentService implements IDepartmentService {

	@Autowired
	private IDepartmentRepository repository;

	public List<Department> getAllDepartments() {
		return repository.findAll();
	}

	public Page<Department> getAllDepartmentByPage(Pageable pageable){
		return repository.findAll(pageable);
	}

	public Department getDepartmentByID(int id) {
		return repository.findById(id).get();
	}

	public void createDepartment(Department department) {
		repository.save(department);
	}

	public void updateDepartment(Department department) {
		repository.save(department);
	}

	public void deleteDepartment(int id) {
		repository.deleteById(id);
	}

	public boolean isDepartmentExistsByID(int id) {
		return repository.existsById(id);
	}

	public Department getDepartmentByName(String name){
		return repository.findByName(name);
	}


}

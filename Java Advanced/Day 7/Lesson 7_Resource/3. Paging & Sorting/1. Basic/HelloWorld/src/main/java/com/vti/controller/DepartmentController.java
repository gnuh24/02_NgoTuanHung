package com.vti.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vti.entity.Department;
import com.vti.service.IDepartmentService;

@RestController
@RequestMapping(value = "api/v1/departments")
public class DepartmentController {

	@Autowired
	private IDepartmentService service;

	@GetMapping()
	public Page<Department> getAllDepartments(Pageable pagable) {
		return service.getAllDepartments(pagable);
	}

	@GetMapping(value = "/name/{name}")
	public Page<Department> getDepartmentByName(
			@PathVariable(name = "name") String name, 
			Pageable pagable) {
		return service.getDepartmentByName(name, pagable);
	}

}


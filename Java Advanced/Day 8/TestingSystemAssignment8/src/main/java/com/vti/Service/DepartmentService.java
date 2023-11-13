package com.vti.Service;

import com.vti.Entity.Department;
import com.vti.Filler.DepartmentFillerForm;
import com.vti.Form.CreatingDepartmentForm;
import com.vti.Form.UpdateDepartmentForm;
import com.vti.Repository.IDepartmentRepository;
import com.vti.Specification.DepartmentSpecification;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service

public class DepartmentService implements IDepartmentService{
    @Autowired
    private IDepartmentRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public Page<Department> getAllDepartments(Pageable pageable, String search, DepartmentFillerForm form){
        Specification<Department> where = DepartmentSpecification.buildWhere(search, form);
        return repository.findAll(where, pageable);
    }
    public Department getDepartmentByName(String name){
        return repository.findByName(name);
    }

    public Department getDepartmentById(int id){
        return repository.findById(id).get();

    }
    @Transactional

    public void createDepartment(CreatingDepartmentForm form){
        Department department = modelMapper.map(form, Department.class);
        repository.save(department);
    }

    public void updateDepartment(UpdateDepartmentForm form){
        Department department = modelMapper.map(form, Department.class);

        repository.save(department);
    }



}

package com.vti.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Department;

import java.util.List;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    public Department findByName(String name);

    public Page<Department> findAll (Pageable pageable);

}

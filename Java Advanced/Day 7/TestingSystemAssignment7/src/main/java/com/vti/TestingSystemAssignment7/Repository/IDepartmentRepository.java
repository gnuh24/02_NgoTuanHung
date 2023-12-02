package com.vti.TestingSystemAssignment7.Repository;

import com.vti.TestingSystemAssignment7.Entity.Department;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IDepartmentRepository extends JpaRepository<Department, Integer> {
    public Department findByName(String name);

    public Page<Department> findAll(Pageable pageable);
}

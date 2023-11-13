package com.vti.Repository;

import com.vti.Entity.Account;
import com.vti.Entity.Department;
import com.vti.Filler.DepartmentFillerForm;
import com.vti.Service.DepartmentService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface IDepartmentRepository extends JpaRepository<Department, Integer>, JpaSpecificationExecutor<Department> {
    public Department findByName(String name);

    Page<Department> findAll(Specification<Department> specification, Pageable pageable);

}

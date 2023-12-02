package com.vti.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vti.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

	Department findByName(String name);

	List<Department> findByTotalMemberGreaterThanEqual(int minTotalMember);

	List<Department> findByNameAndTotalMemberGreaterThanEqual(String name, int minTotalMember);
}

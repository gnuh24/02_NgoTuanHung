package com.vti.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.vti.entity.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer> {

	@Modifying
	@Query("DELETE FROM Department d WHERE DepartmentName = :nameParameter")
	void deleteByName(@Param("nameParameter") String name);
}

package com.vti.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

import com.vti.entity.Department;
import com.vti.utils.HibernateUtils;

@Repository
@Primary
public class DepartmentRepositoryV2 implements IDepartmentRepository {

	@Autowired
	private HibernateUtils hibernateUtils;

	public List<Department> getAllDepartments() {
		// other logic ...
		return null;
	}

	/*
	 * @see com.vti.repository.IDepartmentRepository#getDepartmentByID(int)
	 */
	@Override
	public Department getDepartmentByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see com.vti.repository.IDepartmentRepository#getDepartmentByName(java.lang.
	 * String)
	 */
	@Override
	public Department getDepartmentByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/*
	 * @see
	 * com.vti.repository.IDepartmentRepository#createDepartment(com.vti.entity.
	 * Department)
	 */
	@Override
	public void createDepartment(Department department) {
		// TODO Auto-generated method stub

	}

	/*
	 * @see com.vti.repository.IDepartmentRepository#updateDepartment(int,
	 * java.lang.String)
	 */
	@Override
	public void updateDepartment(int id, String newName) {
		// TODO Auto-generated method stub

	}

	/*
	 * @see
	 * com.vti.repository.IDepartmentRepository#updateDepartment(com.vti.entity.
	 * Department)
	 */
	@Override
	public void updateDepartment(Department department) {
		// TODO Auto-generated method stub

	}

	/*
	 * @see com.vti.repository.IDepartmentRepository#deleteDepartment(int)
	 */
	@Override
	public void deleteDepartment(int id) {
		// TODO Auto-generated method stub

	}

	/*
	 * @see com.vti.repository.IDepartmentRepository#isDepartmentExistsByID(int)
	 */
	@Override
	public boolean isDepartmentExistsByID(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	/*
	 * @see
	 * com.vti.repository.IDepartmentRepository#isDepartmentExistsByName(java.lang.
	 * String)
	 */
	@Override
	public boolean isDepartmentExistsByName(String name) {
		// TODO Auto-generated method stub
		return false;
	}
}

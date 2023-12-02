package com.vti;

import com.vti.entity.Department;

public class Program {

	public static void main(String[] args) {
		Department department = new Department();
		department.setId(1);
		department.setName("Nguyen Van A");
		System.out.println(department.getName());
	}
}



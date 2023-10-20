package Demo;

import Repository.DepartmentRepository;
import entity.Department;

public class DemoDetailDepartment {

	public static void main(String[] args) {
		DepartmentRepository test = new DepartmentRepository();
		for (Department d : test.getAllDepartment()) {
			System.out.println(d);
		}
		
	}

}

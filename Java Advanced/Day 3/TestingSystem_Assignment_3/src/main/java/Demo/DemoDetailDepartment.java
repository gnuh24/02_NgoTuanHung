package Demo;

import Repository.AddressRepository;
import Repository.DepartmentRepository;
import entity.Address;
import entity.Department;

public class DemoDetailDepartment {

	public static void main(String[] args) {
		DepartmentRepository test1 = new DepartmentRepository();
		for (Department d : test1.getAllDepartment()) {
			System.out.println(d);
		}
		
//		AddressRepository test2= new AddressRepository();
//		for (Address d : test2.getAllAddresses()) {
//			System.out.println(d);
//		}
		
	}

}

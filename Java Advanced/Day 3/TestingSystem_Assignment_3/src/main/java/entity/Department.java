package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "Department")
public class Department implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="DepartmentID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short departmentID;
	
	@Column(name="DepartmentName",
			length=30,
			nullable=false,
			unique=true)
	private String departmentName;

	 @OneToOne(mappedBy = "department")
	 private DetailDepartment detailDepartment;
	
	public Department() {
	}



	public Department(String departmentName) {
		this.departmentName = departmentName;
	}



	public Department(short departmentID, String departmentName) {
		this.departmentID = departmentID;
		this.departmentName = departmentName;
	}



	public short getDepartmentID() {
		return departmentID;
	}



	public void setDepartmentID(short departmentID) {
		this.departmentID = departmentID;
	}



	public String getDepartmentName() {
		return departmentName;
	}



	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}



	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + ", AddressName="
				+ detailDepartment.getAddress().getAddressName() + "]";
	}



	
	
	
}

package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;
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

	 
	 @OneToMany (mappedBy = "department", fetch = FetchType.EAGER ) //Dùng fetch = FetchType.EAGER nếu muốn thấy kết quả đẹp hơn trên console
	 private List<Account> listOfAccount;
	 
	 


	public DetailDepartment getDetailDepartment() {
		return detailDepartment;
	}



	public void setDetailDepartment(DetailDepartment detailDepartment) {
		this.detailDepartment = detailDepartment;
	}



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

	


	public List<Account> getListOfAccount() {
		return listOfAccount;
	}



	public void setListOfAccount(List<Account> listOfAccount) {
		this.listOfAccount = listOfAccount;
	}



	@Override
	public String toString() {
		return "Department [departmentID=" + departmentID + ", departmentName=" + departmentName + "]";
	}



	



	
	
	
}

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
@Inheritance(strategy = InheritanceType.JOINED)
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

	 @OneToMany (mappedBy = "department") //Dùng fetch = FetchType.EAGER nếu muốn thấy kết quả đẹp hơn trên console
	 private List<Account> listOfAccount;
	 



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

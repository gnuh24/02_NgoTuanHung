package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "DetailDepartment")
public class DetailDepartment implements Serializable{
	

	private static final long serialVersionUID = 1L;
	@Id
	@OneToOne
    @JoinColumn(name = "DepartmentID")
    private Department department;

    @OneToOne
    @JoinColumn(name = "AddressID", unique = true, nullable = false)
    private Address address;
	
	@Column(name = "EmulationPoint")
	private short emulationPoint;

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public short getEmulationPoint() {
		return emulationPoint;
	}

	public void setEmulationPoint(short emulationPoint) {
		this.emulationPoint = emulationPoint;
	}

	@Override
	public String toString() {
		return "DetailDepartment [department=" + department.getDepartmentName() + ", address=" + address.getAddressName() + ", emulationPoint="
				+ emulationPoint + "]";
	}
	
	
	
}

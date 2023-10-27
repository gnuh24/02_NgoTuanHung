package entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name = "DetailDepartment")
@PrimaryKeyJoinColumn(name = "departmentID")
public class DetailDepartment extends Department{
	
	private static final long serialVersionUID = 1L;
	
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AddressID", unique = true, nullable = false)
    private Address address;
	
	@Column(name = "EmulationPoint")
	private short emulationPoint;

	
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
		return "DetailDepartment [address=" + address + ", emulationPoint=" + emulationPoint + "]";
	}


	
	
}

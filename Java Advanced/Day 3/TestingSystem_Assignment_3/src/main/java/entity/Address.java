package entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Address")
public class Address implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "AddressID")
    private short addressID;

    @Column(name = "AddressName", nullable = false, unique = true, length = 100)
    private String addressName;
    
    @OneToOne(mappedBy = "address")
    private DetailDepartment detailDepartment;

    
    
	public DetailDepartment getDetailDepartment() {
		return detailDepartment;
	}

	public void setDetailDepartment(DetailDepartment detailDepartment) {
		this.detailDepartment = detailDepartment;
	}

	public short getAddressID() {
		return addressID;
	}

	public void setAddressID(short addressID) {
		this.addressID = addressID;
	}

	public String getAddressName() {
		return addressName;
	}

	public void setAddressName(String addressName) {
		this.addressName = addressName;
	}

	@Override
	public String toString() {
		return "Address [addressID=" + addressID + ", addressName=" + addressName + "]";
	}




	




	
}

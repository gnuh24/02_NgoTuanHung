package entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;


@Entity
@Table (name = "Manager")
@PrimaryKeyJoinColumn(name = "accountID")
public class Manager extends Account{

	private static final long serialVersionUID = 1L;
	@Column (name = "ManagementNumberOfYear",
			nullable = false)
	private short managementNumberOfYear;

	public short getManagementNumberOfYear() {
		return managementNumberOfYear;
	}

	public void setManagementNumberOfYear(short managementNumberOfYear) {
		this.managementNumberOfYear = managementNumberOfYear;
	}

	@Override
	public String toString() {
		return "Manager [managementNumberOfYear=" + managementNumberOfYear + "]";
	}

	
	
	
	
}

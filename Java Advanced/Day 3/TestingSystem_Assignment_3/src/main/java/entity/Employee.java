package entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table (name = "`Employee`")
@PrimaryKeyJoinColumn(name = "accountID")
public class Employee extends Account{

	private static final long serialVersionUID = 1L;
	
	
	@Column (name = "WorkingNumberOfYear",
			nullable = false)
	private short workingNumberOfYear;


	public short getWorkingNumberOfYear() {
		return workingNumberOfYear;
	}

	public void setWorkingNumberOfYear(short workingNumberOfYear) {
		this.workingNumberOfYear = workingNumberOfYear;
	}

	@Override
	public String toString() {
		return "Employee [workingNumberOfYear=" + workingNumberOfYear + "]";
	}

	
}
	
	
	

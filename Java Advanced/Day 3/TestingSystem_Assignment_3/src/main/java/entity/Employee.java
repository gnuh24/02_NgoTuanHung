package entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table (name = "`Employee`")
public class Employee implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@OneToOne 
	@JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
	private Account account;
	
	@Column (name = "WorkingNumberOfYear",
			nullable = false)
	private short workingNumberOfYear;

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public short getWorkingNumberOfYear() {
		return workingNumberOfYear;
	}

	public void setWorkingNumberOfYear(short workingNumberOfYear) {
		this.workingNumberOfYear = workingNumberOfYear;
	}

	@Override
	public String toString() {
	    String username = (account != null) ? account.getUsername() : "N/A";
	    return "Employee [accountID=" + username + ", workingNumberOfYear=" + workingNumberOfYear + "]";
	}
}
	
	
	

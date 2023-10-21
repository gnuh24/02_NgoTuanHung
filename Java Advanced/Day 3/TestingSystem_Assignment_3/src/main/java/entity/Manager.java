package entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table (name = "Manager")
public class Manager implements Serializable{
	
	@Id
	@OneToOne 
	@JoinColumn(name = "AccountID", referencedColumnName = "AccountID")
	private Account accountID;
	
	@Column (name = "ManagementNumberOfYear",
			nullable = false)
	private short managementNumberOfYear;

	public Account getAccountID() {
		return accountID;
	}

	public void setAccountID(Account accountID) {
		this.accountID = accountID;
	}

	public short getManagementNumberOfYear() {
		return managementNumberOfYear;
	}

	public void setManagementNumberOfYear(short managementNumberOfYear) {
		this.managementNumberOfYear = managementNumberOfYear;
	}

	@Override
	public String toString() {
		return "Manager [accountID=" + accountID.getUsername() + ", managementNumberOfYear=" + managementNumberOfYear + "]";
	}
	
	
	
	
}

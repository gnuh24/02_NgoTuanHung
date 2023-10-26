package entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;


@Entity
@Table(name = "GroupAccount")
@IdClass(GroupAccountPK.class)
public class GroupAccount implements Serializable{

	private static final long serialVersionUID = 1L;

	@ManyToOne
	@Id
	@JoinColumn(name = "AccountID", referencedColumnName = "AccountID", nullable = false)
	private Account accountID;

	@ManyToOne
	@Id
	@JoinColumn(name = "GroupID", referencedColumnName = "GroupID", nullable = false)
	private Group groupID;

	
	@Column(name ="JoinDate")
	private Date joinDate;
	
	@PrePersist
	public void prePersist() {
		if (joinDate == null) {
			joinDate = new Date();
		}
		
	}

	

	public Account getAccountID() {
		return accountID;
	}



	public void setAccountID(Account accountID) {
		this.accountID = accountID;
	}



	public Group getGroupID() {
		return groupID;
	}



	public void setGroupID(Group groupID) {
		this.groupID = groupID;
	}



	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}



	@Override
	public String toString() {
		return "GroupAccount [accountID=" + accountID.getFullname() + ", groupID=" + groupID.getGroupName() + ", joinDate=" + joinDate + "]";
	}
	
	
	
	
}

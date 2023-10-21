package entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import Repository.DepartmentRepository;
import Repository.PositionRepository;
import Repository.SalaryRepository;
import entity.Position.PositionName;
import entity.Salary.SalaryName;

@Entity
@Table (name = "Account")
public class Account implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column (name="AccountId")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short accountID;
	
	@Column (name="Email",
			length=50,
			nullable=false,
			unique=true,
			updatable=false)
	private String email;
	
	@Column (name="Username",
			length=50,
			nullable=false,
			unique=true,
			updatable=false)
	private String username;
	@Column (name="firstname",
			length=50,
			nullable=false)
	private String firstname;
	
	@Column (name="lastname",
			length=50,
			nullable=false)
	private String lastname;
		
	@Column (name="createDate")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@ManyToOne
	@JoinColumn(name = "DepartmentID")
	private Department department;
	
	@ManyToOne
	@JoinColumn(name = "PositionID")
	private Position position;
	
	@ManyToOne
	@JoinColumn(name = "SalaryID")
	private Salary salary;
	
	@PrePersist
	public void prePersist() {
		if (createDate == null) {
			createDate = new Date();
		}
		
		if (department == null) {
			DepartmentRepository newDPM = new DepartmentRepository();
			department = newDPM.getDepartmentByName("Waiting");
		}
		
		if (position == null) {
			PositionRepository newPSS = new PositionRepository();
			position = newPSS.getPositionByName(PositionName.Dev);
		}
		
		if (salary == null) {
			SalaryRepository newS = new SalaryRepository();
			salary = newS.getSalaryByName(SalaryName.DEV);
		}
	}
	
	
	public Account(short accountID, String email, String username, String firstname, String lastname, Date createDate) {
		super();
		this.accountID = accountID;
		this.email = email;
		this.username = username;
		this.firstname = firstname;
		this.lastname = lastname;
		this.createDate = createDate;
	}



	public Account() {
		super();
	}





	public short getAccountID() {
		return accountID;
	}



	public void setAccountID(short accountID) {
		this.accountID = accountID;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getUsername() {
		return username;
	}



	public void setUsername(String username) {
		this.username = username;
	}



	public String getFirstname() {
		return firstname;
	}



	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}



	public String getLastname() {
		return lastname;
	}



	public void setLastname(String lastname) {
		this.lastname = lastname;
	}



	public Date getCreateDate() {
		return createDate;
	}



	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	public String getFullname() {
	    return firstname + " " + lastname;
	}


	@Override
	public String toString() {
	    return String.format("Account [\n  accountID=%d,\n  email=%s,\n  username=%s,\n  firstname=%s,\n  lastname=%s, "
	                        + "\n  createDate=%s,\n  department=%s,\n  position=%s,\n  salary=%s\n]",
	                        accountID, email, username, firstname, lastname, createDate,
	                        department != null ? department.getDepartmentName() : null,
	                        position != null ? position.getPositionName() : null,
	                        salary != null ? salary.getSalaryName() : null);
	}





	
	
	
	
}

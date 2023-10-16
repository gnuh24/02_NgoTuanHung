package entity;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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
	
	
	@PrePersist
	public void prePersist() {
		if (createDate == null) {
			createDate = new Date();
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
		return "Account [accountID=" + accountID + ", email=" + email + ", username=" + username +
			", fullname=" + firstname+ " " +lastname + ", createDate=" + createDate + "]";
	}
	
	
	
	
}

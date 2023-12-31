package entity;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
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
@Inheritance(strategy = InheritanceType.JOINED)
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
		
	
	/*___________________________________________GROUP___________________________________________*/
	@OneToMany (mappedBy = "creator" ,fetch = FetchType.EAGER)
	private List <Group> ListOfGroup;
	
	
	public List<Group> getListOfGroup() {
		return ListOfGroup;
	}

	public void setListOfGroup(List<Group> listOfGroup) {
		ListOfGroup = listOfGroup;
	}

	
	/*__________________________________________Question____________________________________*/
	@OneToOne(mappedBy = "creator", fetch = FetchType.EAGER)
	private Question question;
	
	
	
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}
	
	/*___________________________________EXAM_____________________________________*/
	@OneToMany(mappedBy = "creator")
	//@LazyCollection(LazyCollectionOption.FALSE)
	private List<Exam> listOfExam;
	
	

	public List<Exam> getListOfExam() {
		return listOfExam;
	}

	public void setListOfExam(List<Exam> listOfExam) {
		this.listOfExam = listOfExam;
	}

	/*_______________________________GROUP_ACCOUNT_________________________________________*/
	@OneToMany(mappedBy = "accountID")
	private List<GroupAccount> listOfGroupAccount;


	
	
	public List<GroupAccount> getListOfGroupAccount() {
		return listOfGroupAccount;
	}

	public void setListOfGroupAccount(List<GroupAccount> listOfGroupAccount) {
		this.listOfGroupAccount = listOfGroupAccount;
	}

	/*______________________________________PrePersist__________________________________*/
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
	
	
	
	


	public Department getDepartment() {
		return department;
	}



	public void setDepartment(Department department) {
		this.department = department;
	}



	public Position getPosition() {
		return position;
	}



	public void setPosition(Position position) {
		this.position = position;
	}



	public Salary getSalary() {
		return salary;
	}



	public void setSalary(Salary salary) {
		this.salary = salary;
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
		return "Account [accountID=" + accountID + ", email=" + email + ", username=" + username + ", firstname="
				+ firstname + ", lastname=" + lastname + ", createDate=" + createDate + "]";
	}


	




	
	
	
	
}

package entity;
import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "Salary")
public class Salary implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Column(name = "SalaryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short salaryID;
	
	@Column(name="SalaryName",
			nullable=false,
			unique=true)
	@Convert(converter = SalaryNameConverter.class)

	private SalaryName salaryName;

	public Salary() {
		super();
	}



	public Salary(SalaryName salaryName) {
		super();
		this.salaryName = salaryName;
	}



	public Salary(short salaryID, SalaryName salaryName) {
		super();
		this.salaryID = salaryID;
		this.salaryName = salaryName;
	}
	

	public short getSalaryID() {
		return salaryID;
	}



	public void setSalaryID(short salaryID) {
		this.salaryID = salaryID;
	}



	public SalaryName getSalaryName() {
		return salaryName;
	}



	public void setSalaryName(SalaryName salaryName) {
		this.salaryName = salaryName;
	}



	@Override
	public String toString() {
		return "Salary [salaryID=" + salaryID + ", salaryName=" + salaryName + "]";
	}


	public enum SalaryName {
	    DEV("600"), TEST("700"), SCRUM_MASTER("1500"), PM("2000");

	    private String salaryNameSQL;

	    private SalaryName(String salaryNameSQL) {
	        this.salaryNameSQL = salaryNameSQL;
	    }

	    public String getSalaryNameSQL() {
	        return this.salaryNameSQL;
	    }
		
		public static SalaryName toEnum(String sqlSalaryName) {
			for (SalaryName item : SalaryName.values()) {
				if (item.getSalaryNameSQL().equals(sqlSalaryName)) {
					return item;
				}
			}
			return null;
		}
	}
			
}

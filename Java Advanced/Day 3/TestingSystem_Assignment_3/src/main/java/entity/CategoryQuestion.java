package entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name="CategoryQuestion")

public class CategoryQuestion implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="CategoryID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short categoryID;
	
	@Column(name="CategoryName",
			length=50,
			nullable=false,
			unique=true)
	private String categoryName;
	
	/*__________________________________________Question____________________________________*/
	@OneToMany (mappedBy = "categoryQuestion" ,fetch = FetchType.EAGER)
	private List <Question> ListOfQuestion;
	
	public List<Question> getListOfQuestion() {
		return ListOfQuestion;
	}

	public void setListOfQuestion(List<Question> listOfQuestion) {
		ListOfQuestion = listOfQuestion;
	}
	
	
	
	

	public CategoryQuestion() {
	}

	public CategoryQuestion(String categoryName) {
		this.categoryName = categoryName;
	}

	public CategoryQuestion(short categoryID, String categoryName) {
		this.categoryID = categoryID;
		this.categoryName = categoryName;
	}

	public short getCategoryID() {
		return categoryID;
	}

	public void setCategoryID(short categoryID) {
		this.categoryID = categoryID;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "CategoryQuestion [categoryID=" + categoryID + ", categoryName=" + categoryName + "]";
	}
	
	
}

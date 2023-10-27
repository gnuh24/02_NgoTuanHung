package entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="Exam")
public class Exam implements Serializable{
	private static final long serialVersionUID = 1L;
	
	 @Column(name = "ExamID")
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private short examID;
	 
	 @Column(name="code",
			 length = 10,
			 updatable = false)
	 private String code;
	 
	 
	 @Column(name = "title",
			 length = 50,
			 nullable = false)
	 private String title;
	 
	 @Column(name = "Duration",
			 nullable = false,
			 columnDefinition = "short default 45")
	 private short duration;
	 
	 @Column(name = "CreateDate",
			 updatable=false)
	 @Temporal(TemporalType.TIMESTAMP)
	 private Date createDate;
	 
	 
	 @ManyToOne
	 @JoinColumn(name = "CategoryID", nullable = false)
	 private CategoryQuestion categoryQuestion;
	 
	 @ManyToOne
	 @JoinColumn(name = "CreatorID", nullable = false, updatable = false)
	 private Account creator;

	 
	 /*__________________________________________Exam_Question___________________________________________________*/
	@OneToMany (mappedBy = "examID")
	public List<ExamQuestion> listOfExamQuestion;
	 
	 public List<ExamQuestion> getListOfExamQuestion() {
		return listOfExamQuestion;
	}

	public void setListOfExamQuestion(List<ExamQuestion> listOfExamQuestion) {
		this.listOfExamQuestion = listOfExamQuestion;
	}



	public CategoryQuestion getCategoryQuestion() {
		return categoryQuestion;
	}



	public void setCategoryQuestion(CategoryQuestion categoryQuestion) {
		this.categoryQuestion = categoryQuestion;
	}



	public Account getCreator() {
		return creator;
	}



	public void setCreator(Account creator) {
		this.creator = creator;
	}



	@PrePersist
	 public void prePersist() {
		 if (createDate == null) {
			 createDate = new Date();
		 }
		 if (code == null) {
			 if (duration >= 180) {
				 code = "L-1";
			 }
			 else if (duration >= 90) {
				 code = "M-1";
			 }
			 else code = "S-1";
		 }
		 
		
	 }
	 
	 

	public short getExamID() {
		return examID;
	}

	public void setExamID(short examID) {
		this.examID = examID;
	}

	public String getCode1() {
		return code;
	}

	public void setCode1(String code) {
		this.code = code;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public short getDuration() {
		return duration;
	}

	public void setDuration(short duration) {
		this.duration = duration;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}



	@Override
	public String toString() {
		return "Exam [examID=" + examID + ", code=" + code + ", title=" + title + ", duration=" + duration
				+ ", createDate=" + createDate + "]";
	}

	
	 
	 
			 
}

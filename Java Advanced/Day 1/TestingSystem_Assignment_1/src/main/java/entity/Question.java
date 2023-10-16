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
@Table (name="Question")
public class Question implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="QuestionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short questionID;
	
	@Column(name="Content",
			length=100,
			nullable=false)
	private String content;
	
	@Column (name="CreateDate",
			updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@PrePersist
	public void prePersist() {
		if (createDate == null) {
			createDate = new Date();
		}
	}

	public Question() {
		super();
	}



	public Question(String content) {
		super();
		this.content = content;
	}



	public Question(short questionID, String content, Date createDate) {
		super();
		this.questionID = questionID;
		this.content = content;
		this.createDate = createDate;
	}



	public short getQuestionID() {
		return questionID;
	}

	public void setQuestionID(short questionID) {
		this.questionID = questionID;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Question [questionID=" + questionID + ", content=" + content + ", createDate=" + createDate + "]";
	}
	
	


}

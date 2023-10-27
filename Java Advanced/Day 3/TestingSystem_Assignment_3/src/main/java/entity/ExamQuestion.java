package entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ExamQuestion")
@IdClass(ExamQuestion.class)
public class ExamQuestion implements Serializable{
	private static final long serialVersionUID = 1L;

	@Id
	@ManyToOne
	@JoinColumn(name = "ExamID", nullable = false)
	private Exam examID;
	
	@Id
	@ManyToOne
	@JoinColumn(name = "QuestionID", nullable = false)
	private Question questionID;

	public Exam getExamID() {
		return examID;
	}

	public void setExamID(Exam examID) {
		this.examID = examID;
	}

	public Question getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Question questionID) {
		this.questionID = questionID;
	}

	@Override
	public String toString() {
		return "ExamQuestion [examID=" + examID.getExamID() + ", questionID=" + questionID.getQuestionID() + "]";
	}
	
	
	
}

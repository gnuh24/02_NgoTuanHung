package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ExamQuestionPK implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "ExamID")
	private Exam examID;
	
	@Column(name = "QuestionID")
	private Question questionID;

	public ExamQuestionPK(Exam examID, Question questionID) {
		super();
		this.examID = examID;
		this.questionID = questionID;
	}

	public ExamQuestionPK() {
		super();
	}

	
}

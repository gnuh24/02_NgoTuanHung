package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="Answer")

public class Answer implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="Answers")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short answers;
	
	@Column(name="Content",
			length=100,
			nullable=false)
	private String content;
	
	@Column(name="isCorrect",
			columnDefinition="bit default 1")
	private boolean isCorrect;
	
	@ManyToOne
	@JoinColumn(name = "QuestionID", nullable = false)
	private Question question;
	
	
	
	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Answer() {
		super();
	}

	public Answer(String content) {
		super();
		this.content = content;
	}

	public Answer(short answers, String content) {
		super();
		this.answers = answers;
		this.content = content;
	}

	public Answer(short answers, String content, boolean isCorrect) {
		super();
		this.answers = answers;
		this.content = content;
		this.isCorrect = isCorrect;
	}

	public short getAnswers() {
		return answers;
	}

	public void setAnswers(short answers) {
		this.answers = answers;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	@Override
	public String toString() {
		return "Answer [answers=" + answers + ", content=" + content + ", isCorrect=" + isCorrect + "]";
	}
	
	
	
	
	
	
}

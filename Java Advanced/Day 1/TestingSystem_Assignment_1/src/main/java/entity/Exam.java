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

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="Exam")
public class Exam implements Serializable{
	private static final long serialVersionUID = 1L;
	
	 @Column(name = "ExamID")
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private short examID;
	 
	 @Column(name="code1",
			 length = 10,
			 updatable = false)
	 private String code1;
	 
	 @Column(name="code2",
			 length = 10,
			 updatable = false)
	 private String code2;
	 
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
	 
	 @PrePersist
	 public void prePersist() {
		 if (createDate == null) {
			 createDate = new Date();
		 }
		 if (code1 == null) {
			 if (duration >= 180) {
				 code1 = "L-1";
			 }
			 else if (duration >= 90) {
				 code1 = "M-1";
			 }
			 else code1 = "S-1";
		 }
		 
		 if (code2 == null) {
			 if (duration >= 180) {
				 code2 = "L-1";
			 }
			 else if (duration >= 90) {
				 code2 = "M-1";
			 }
			 else code2 = "S-1";
		 }
	 }

	public short getExamID() {
		return examID;
	}

	public void setExamID(short examID) {
		this.examID = examID;
	}

	public String getCode1() {
		return code1;
	}

	public void setCode1(String code1) {
		this.code1 = code1;
	}

	public String getCode2() {
		return code2;
	}

	public void setCode2(String code2) {
		this.code2 = code2;
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
		return "Exam [examID=" + examID + ", code1=" + code1 + ", code2=" + code2 + ", title=" + title + ", duration="
				+ duration + ", createDate=" + createDate + "]";
	}
	 
	 
			 
}

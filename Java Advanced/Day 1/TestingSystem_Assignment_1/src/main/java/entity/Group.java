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
@Table(name = "`Group`")
public class Group implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "GroupID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short groupId;
	
	@Column(name = "GroupName", 
			length=50, 
			nullable=false,
			unique=true
			)
	private String groupName;
	
	@Column(name = "createDate", 
			updatable=false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate;
	
	@PrePersist
	public void prePersist() {
		if (createDate == null) {
			createDate = new Date();
		}
	}

	
	public Group(short groupId, String groupName, Date createDate) {
		this.groupId = groupId;
		this.groupName = groupName;
		this.createDate = createDate;
	}
	
	public Group() {}

	public short getGroupId() {
		return groupId;
	}

	public void setGroupId(short groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Override
	public String toString() {
		return "Group [groupId=" + groupId + ", groupName=" + groupName + ", createDate=" + createDate + "]";
	}
	
}

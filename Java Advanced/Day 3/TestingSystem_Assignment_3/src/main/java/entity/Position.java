package entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table (name = "Position")

public class Position implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Column(name="PositionID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short PositionID;
	
	@Column (name="PositionName",
			nullable = false,
			unique = true)
	@Enumerated(EnumType.STRING)
	private PositionName PositionName;

	
	
	
	

	public Position() {
		super();
	}





	public Position(short positionID, entity.Position.PositionName positionName) {
		super();
		PositionID = positionID;
		PositionName = positionName;
	}





	public short getPositionID() {
		return PositionID;
	}





	public void setPositionID(short positionID) {
		PositionID = positionID;
	}





	public PositionName getPositionName() {
		return PositionName;
	}





	public void setPositionName(PositionName positionName) {
		PositionName = positionName;
	}





	@Override
	public String toString() {
		return "Position [PositionID=" + PositionID + ", PositionName=" + PositionName + "]";
	}





	public enum PositionName{
		 Dev, Test, ScrumMaster, PM
	}
}


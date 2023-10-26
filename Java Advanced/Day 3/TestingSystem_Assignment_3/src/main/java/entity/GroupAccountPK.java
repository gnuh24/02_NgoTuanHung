package entity;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;

@Embeddable
public class GroupAccountPK implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@JoinColumn(name = "accountID")
	private Account accountID;

	@JoinColumn(name = "groupID")
	private Group groupID;
	
}

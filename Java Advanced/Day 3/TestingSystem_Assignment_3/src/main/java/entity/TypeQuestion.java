package entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table (name=  "TypeQuestion")

public class TypeQuestion implements Serializable{
	private static final long serialVersionUID = 1L;

	@Column(name = "TypeID")
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private short typeId;
	
	
	@Column(name="TypeName",
			length=50,
			nullable=false,
			unique=true)
	@Convert(converter = TypeQuestionConverter.class)
	private TypeName typeName;
	
	/*__________________________________________Question____________________________________*/
	@OneToMany(mappedBy = "typeQuestion", fetch = FetchType.EAGER)
	private List<Question> listOfQuestion;
	
	public List<Question> getListOfQuestion() {
		return listOfQuestion;
	}

	public void setListOfQuestion(List<Question> listOfQuestion) {
		this.listOfQuestion = listOfQuestion;
	}
	
	
	
	
	
	
	
	
	public short getTypeId() {
		return typeId;
	}



	public void setTypeId(short typeId) {
		this.typeId = typeId;
	}



	



	public TypeQuestion() {
		super();
	}



	public TypeQuestion(TypeName typeName) {
		super();
		this.typeName = typeName;
	}



	public TypeQuestion(short tpyeId, TypeName typeName) {
		super();
		this.typeId = tpyeId;
		this.typeName = typeName;
	}



	@Override
	public String toString() {
		return "TypeQuestion [typeId=" + typeId + ", typeName=" + typeName + "]";
	}



	public short getTpyeId() {
		return typeId;
	}



	public void setTpyeId(short tpyeId) {
		this.typeId = tpyeId;
	}



	public TypeName getTypeName() {
		return typeName;
	}



	public void setTypeName(TypeName typeName) {
		this.typeName = typeName;
	}

	public enum TypeName{
		Essay("0"), Multiple_Choice("1");
		
		private String typeNameSQL;
		
		private TypeName(String typeNameSQL) {
			this.typeNameSQL = typeNameSQL;
		}
		
		public String getTypeNameSQL() {
			return typeNameSQL;
		}

		public static TypeName getTypeName(String typeNameSQL) {
			for (TypeName type : TypeName.values()) {
					if (type.getTypeNameSQL().equals(typeNameSQL)) {
						return type;
					}
			}
			return null;
		}
	}
}

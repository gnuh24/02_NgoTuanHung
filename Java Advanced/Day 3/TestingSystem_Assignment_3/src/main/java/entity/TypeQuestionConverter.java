package entity;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import entity.TypeQuestion.TypeName;

@Converter(autoApply = true)
public class TypeQuestionConverter implements AttributeConverter<TypeQuestion.TypeName, String>{
	public String convertToDatabaseColumn(TypeName typeName) {
		if (typeName == null) {
			return null;
		}
		return typeName.getTypeNameSQL();
	}

	@Override
	public TypeName convertToEntityAttribute(String sqlTypeName) {
		if (sqlTypeName == null) {
			return null;
		}
		return TypeQuestion.TypeName.getTypeName(sqlTypeName);
	}
}

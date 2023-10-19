package entity;


import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import entity.Salary.SalaryName;;

@Converter(autoApply = true)

public class SalaryNameConverter implements AttributeConverter<Salary.SalaryName, String>{
	
	public String convertToDatabaseColumn(SalaryName salaryName) {
		if (salaryName == null) {
			return null;
		}
		return salaryName.getSalaryNameSQL();
	}

	@Override
	public SalaryName convertToEntityAttribute(String salaryNameSQL) {
		if (salaryNameSQL == null) {
			return null;
		}
		return Salary.SalaryName.toEnum(salaryNameSQL);
	}
}

package com.vti.form.department;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.PositiveOrZero;

import org.hibernate.validator.constraints.Length;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CreatingDepartmentForm {

	@NotBlank(message = "The name mustn't be null value")
	@Length(max = 50, message = "The name's length is max 50 characters")
	private String name;

	@NotNull(message = "The Total Member mustn't be null value")
	@PositiveOrZero(message = "The Total Member must be greater than or equal 0")
	private Integer totalMember;

	@Pattern(regexp = "DEV|TEST|PM", message = "The type must be DEV, TEST or PM")
	private String type;
}

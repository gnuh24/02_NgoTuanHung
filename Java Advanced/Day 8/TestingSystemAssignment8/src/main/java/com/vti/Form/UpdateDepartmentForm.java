package com.vti.Form;

import com.vti.Enum.DepartmentType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;
@Data
@NoArgsConstructor
public class UpdateDepartmentForm {
    private int id;

    @NotBlank(message = "{UpdateDepartment.form.NotBlank}")
    @Length(min = 2, max = 6, message = "{UpdateDepartment.form.Length}")

    private String name;

    private int totalMember;

    private DepartmentType type;
}





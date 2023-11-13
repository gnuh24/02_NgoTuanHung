package com.vti.Form;

import com.vti.Enum.DepartmentType;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
public class CreatingDepartmentForm {

    @NotBlank(message = "Name không được null")
    @Length(min = 2, max = 6, message = "Độ dài trong khoảng từ 2 -> 6")
    private String name;
    private int totalMember;
    private DepartmentType type;
}

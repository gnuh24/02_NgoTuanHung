package com.vti.DTO;

import com.vti.Enum.DepartmentType;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.springframework.hateoas.RepresentationModel;


@Data
public class AccountDTO extends RepresentationModel<DepartmentDTO> {
    @NonNull
    private int id;

    @NonNull
    private String username;

    @NonNull
    private String departmentName;

    @NonNull
    private DepartmentType departmentType;

    public AccountDTO(){}




}

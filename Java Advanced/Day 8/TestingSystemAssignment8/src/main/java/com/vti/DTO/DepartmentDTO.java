package com.vti.DTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.vti.Enum.DepartmentType;
import lombok.Data;
import lombok.NonNull;
import org.springframework.hateoas.RepresentationModel;

import java.util.Date;
import java.util.List;

@Data

public class DepartmentDTO extends RepresentationModel<DepartmentDTO> {
    @NonNull
    private int id;

    @NonNull
    private String name;

    @NonNull
    private int totalMember;

    @NonNull
    private DepartmentType type;

    @NonNull
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date createDate;



    @NonNull
    private List<AccountDTO> listOfAccounts;

    public DepartmentDTO() {

    }
}

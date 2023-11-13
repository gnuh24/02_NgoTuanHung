package com.vti.Filler;

import com.vti.Enum.DepartmentType;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class DepartmentFillerForm {

    private Integer minId;

    private Integer maxId;

    private Integer minTotalMember;

    private Integer maxTotalMember;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date createDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date minCreateDate;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date maxCreateDate;

    private Integer minYear;

    private Integer maxYear;

    private DepartmentType type;

    private Integer minAccounts;

    private Integer maxAccounts;

    public DepartmentFillerForm(){}
}

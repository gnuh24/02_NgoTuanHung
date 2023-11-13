package com.vti.Entity;

import com.vti.DTO.AccountDTO;
import com.vti.Enum.DepartmentType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Department")
@Data
@NoArgsConstructor(force = true)

public class Department implements Serializable {

    @Column(name = "id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", length = 50, unique = true, nullable = false)
    private String name;

    @Column(name = "total_member")
    private int totalMember;

    @Column(name = "type", nullable = false)
    @Enumerated(EnumType.STRING)
    private DepartmentType type;

    @Column(name = "created_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createDate;

    @OneToMany(mappedBy = "department")
    private List<Account> listOfAccounts;




}

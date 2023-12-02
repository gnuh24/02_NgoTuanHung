package com.vti.TestingSystemAssignment7.Entity;

import jakarta.persistence.*;
import lombok.*;


import java.io.Serializable;

@Entity
@Table(name = "Department")
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class Department implements Serializable {

    @Column(name = "DepartmentID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "TotalMember")
    private short totalMember;

    @NonNull
    @Column(name = "DepartmentName", nullable = false, unique = true)
    private String name;

    public Department(){

    }

}


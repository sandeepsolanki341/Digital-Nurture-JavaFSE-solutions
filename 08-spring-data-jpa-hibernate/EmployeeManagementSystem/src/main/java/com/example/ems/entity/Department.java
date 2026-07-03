package com.example.ems.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

// Ex 2: Department with one-to-many Employees.
@Entity
@Table(name = "department")
@Data
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;
}

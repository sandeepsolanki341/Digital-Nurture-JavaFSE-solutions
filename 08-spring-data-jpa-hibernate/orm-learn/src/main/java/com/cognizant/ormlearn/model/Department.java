package com.cognizant.ormlearn.model;

import javax.persistence.*;
import java.util.Set;

// Doc 2, Hands-on 3 & 5: Department with one-to-many back to Employee.
@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "dp_id")
    private int id;

    @Column(name = "dp_name")
    private String name;

    // Doc 3, Hands-on 2: EAGER removed so HQL 'join fetch' controls loading.
    @OneToMany(mappedBy = "department")
    private Set<Employee> employeeList;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public Set<Employee> getEmployeeList() { return employeeList; }
    public void setEmployeeList(Set<Employee> employeeList) { this.employeeList = employeeList; }

    @Override
    public String toString() {
        return "Department [id=" + id + ", name=" + name + "]";
    }
}

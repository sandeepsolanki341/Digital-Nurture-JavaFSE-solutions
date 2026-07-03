package com.example.ems.repository;

import com.example.ems.entity.Employee;
import com.example.ems.projection.EmployeeNameView;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

// Ex 3, 5, 6, 8: derived queries, @Query, pagination/sorting, projections.
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Ex 5: derived query method.
    List<Employee> findByName(String name);

    // Ex 5: custom JPQL query.
    @Query("SELECT e FROM Employee e WHERE e.email LIKE %:domain%")
    List<Employee> findByEmailDomain(@Param("domain") String domain);

    // Ex 6: pagination + sorting come free from Pageable.
    Page<Employee> findByDepartmentId(Long departmentId, Pageable pageable);

    // Ex 8: interface-based projection.
    List<EmployeeNameView> findByDepartmentName(String departmentName);
}

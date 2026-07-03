package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// Doc 3: HQL/JPQL, aggregate and native queries.
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Doc 3, Hands-on 2: permanent employees, single query via join fetch.
    @Query("SELECT e FROM Employee e "
            + "left join fetch e.department d "
            + "left join fetch e.skillList "
            + "WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // Doc 3, Hands-on 4: average salary of a department.
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :id")
    double getAverageSalary(@Param("id") int id);

    // Doc 3, Hands-on 5: native SQL query.
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}

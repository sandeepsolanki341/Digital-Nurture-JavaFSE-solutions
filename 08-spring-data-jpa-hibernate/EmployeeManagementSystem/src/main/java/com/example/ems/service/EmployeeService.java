package com.example.ems.service;

import com.example.ems.entity.Employee;
import com.example.ems.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

// Ex 4: CRUD service layer.
@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> findAll() { return employeeRepository.findAll(); }
    public Employee findById(Long id) { return employeeRepository.findById(id).orElse(null); }
    public Employee save(Employee employee) { return employeeRepository.save(employee); }
    public void delete(Long id) { employeeRepository.deleteById(id); }

    // Ex 6: paginated + sorted list.
    public Page<Employee> findPage(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }
}

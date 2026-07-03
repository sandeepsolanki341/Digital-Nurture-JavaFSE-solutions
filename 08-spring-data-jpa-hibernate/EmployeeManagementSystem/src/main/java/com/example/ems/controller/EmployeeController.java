package com.example.ems.controller;

import com.example.ems.entity.Employee;
import com.example.ems.service.EmployeeService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Ex 4 + Ex 6: RESTful CRUD + paginated/sorted endpoint.
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public List<Employee> getAll() { return employeeService.findAll(); }

    @GetMapping("/{id}")
    public Employee getById(@PathVariable Long id) { return employeeService.findById(id); }

    @PostMapping
    public Employee create(@RequestBody Employee employee) { return employeeService.save(employee); }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody Employee employee) {
        employee.setId(id);
        return employeeService.save(employee);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { employeeService.delete(id); }

    // Ex 6: /employees/page?page=0&size=5&sortBy=name
    @GetMapping("/page")
    public Page<Employee> getPage(@RequestParam(defaultValue = "0") int page,
                                  @RequestParam(defaultValue = "5") int size,
                                  @RequestParam(defaultValue = "id") String sortBy) {
        return employeeService.findPage(PageRequest.of(page, size, Sort.by(sortBy)));
    }
}

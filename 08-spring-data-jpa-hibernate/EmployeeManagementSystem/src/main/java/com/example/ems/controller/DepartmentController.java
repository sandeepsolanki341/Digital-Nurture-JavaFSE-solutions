package com.example.ems.controller;

import com.example.ems.entity.Department;
import com.example.ems.repository.DepartmentRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// Ex 4: RESTful CRUD for departments.
@RestController
@RequestMapping("/departments")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping
    public List<Department> getAll() { return departmentRepository.findAll(); }

    @PostMapping
    public Department create(@RequestBody Department department) {
        return departmentRepository.save(department);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) { departmentRepository.deleteById(id); }
}

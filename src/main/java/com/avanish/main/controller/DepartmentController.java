package com.avanish.main.controller;

import com.avanish.main.entity.Department;
import com.avanish.main.error.DepartmentNotFoundException;
import com.avanish.main.service.DepartmentService;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {

    private final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/departments")
    public Department savedDepartment(@Valid @RequestBody Department department){
        logger.info("Inside savedDepartment DepartmentController");
        return departmentService.savedDepartment(department);
    }

    @GetMapping("/departments")
    public List<Department> getDepartments()
    {
        logger.info("Inside getDepartments DepartmentController");
        return departmentService.getDepartment();
    }

    @GetMapping("/departments/{id}")
    public Department getDepartmentById(@PathVariable("id") Long departmentId) throws DepartmentNotFoundException {
        logger.info("Inside getDepartmentById DepartmentController");
        return departmentService.getDepartmentById(departmentId);
    }

    @DeleteMapping("/departments/{id}")
    public String deleteDepartmentById(@PathVariable("id") Long departmentId){
        logger.info("Inside deleteDepartmentById DepartmentController");
        departmentService.deleteDepartmentById(departmentId);
        return "Successfully deleted this department";
    }
    @PutMapping("/departments/{id}")
    public Department updateDepartment(@PathVariable("id") Long departmentId, @RequestBody Department department){
        logger.info("Inside updateDepartment DepartmentController");
        return departmentService.updateDepartment(departmentId, department);
    }

    //fetching department using property name
    @GetMapping("/departments/name/{name}")
    public Department fetchDepartmentByName(@PathVariable("name") String departmentName){
        logger.info("Inside fetchDepartmentByName DepartmentController");
        return departmentService.fetchDepartmentByName(departmentName);
    }
}

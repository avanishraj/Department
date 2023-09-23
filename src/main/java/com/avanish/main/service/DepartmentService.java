package com.avanish.main.service;

import com.avanish.main.entity.Department;
import com.avanish.main.error.DepartmentNotFoundException;

import java.util.List;

public interface DepartmentService {
    Department savedDepartment(Department department);

    List<Department> getDepartment();

    Department getDepartmentById(Long departmentId) throws DepartmentNotFoundException;

    void deleteDepartmentById(Long departmentID);

    Department updateDepartment(Long departmentId, Department department);

    Department fetchDepartmentByName(String departmentName);
}

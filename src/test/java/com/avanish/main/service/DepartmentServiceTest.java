package com.avanish.main.service;

import com.avanish.main.entity.Department;
import com.avanish.main.repository.DepartmentRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class DepartmentServiceTest {
    @Autowired
    DepartmentService departmentService;
    @MockBean
    DepartmentRepository departmentRepository;

    @BeforeEach
    void setUp() {
        Department department = Department.builder()
                .departmentName("IIoT")
                .departmentAddress("USAR")
                .departmentCode("IIoT21-54")
                .build();

        Mockito.when(departmentRepository.findByDepartmentNameIgnoreCase("IIoT")).thenReturn(department);
    }

    @Test
    public void whenValidDepartmentName_thenDepartmentShouldFound() {
        String departmentName = "IIoT";
        Department found = departmentService.fetchDepartmentByName(departmentName);
        assertEquals(departmentName, found.getDepartmentName());
    }
}
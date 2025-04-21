package com.deparment_service.service;


import com.deparment_service.dto.DepartmentDto;

public interface DepartmentService {
    DepartmentDto saveDepartment(DepartmentDto departmentDto);
    DepartmentDto getDepartmentByCode(String departmentCode);
    void deleteDepartment(Long id);
}

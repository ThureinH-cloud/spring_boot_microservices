package com.deparment_service.mapper;

import com.deparment_service.dto.DepartmentDto;
import com.deparment_service.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto mapToDepartmentDto(Department department) {
        return new DepartmentDto(
                department.getId(),
                department.getDepartmentName(),
                department.getDepartmentDescription(),
                department.getDepartmentCode()
        );
    }
    public static Department mapToDepartment(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.getId(), departmentDto.getDepartmentName(), departmentDto.getDepartmentDescription(), departmentDto.getDepartmentCode()
        );
    }
}

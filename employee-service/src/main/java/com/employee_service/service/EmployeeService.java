package com.employee_service.service;

import com.employee_service.dto.APIResponseDto;
import com.employee_service.dto.EmployeeDto;

public interface EmployeeService {
    EmployeeDto save(EmployeeDto employeeDto);
    APIResponseDto getEmployeeById(Long id);
    void deleteEmployeeById(Long id);
}

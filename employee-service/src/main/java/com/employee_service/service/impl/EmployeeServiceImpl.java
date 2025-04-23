package com.employee_service.service.impl;

import com.employee_service.dto.APIResponseDto;
import com.employee_service.dto.DepartmentDto;
import com.employee_service.dto.EmployeeDto;
import com.employee_service.dto.OrganizationDto;
import com.employee_service.entity.Employee;
import com.employee_service.mapper.EmployeeMapper;
import com.employee_service.repository.EmployeeRepository;
import com.employee_service.service.APIClient;
import com.employee_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final WebClient webClient;
    private final APIClient apiClient;
    @Override
    public EmployeeDto save(EmployeeDto employeeDto) {
        Employee employee= EmployeeMapper.mapToEmployee(employeeDto);
        var savedEmployee=employeeRepository.save(employee);
        return EmployeeMapper.mapToEmployeeDto(savedEmployee);
    }

    @Override
    public APIResponseDto getEmployeeById(Long id) {
       Employee employee=employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found"));
       DepartmentDto departmentDto= webClient.get().uri("http://localhost:8080/api/departments/"+employee
               .getDepartmentCode()).retrieve().bodyToMono(DepartmentDto.class).block();
        OrganizationDto organizationDto=webClient.get().uri("http://localhost:8083/api/organizations/"+employee.getOrganizationCode()).retrieve().bodyToMono(OrganizationDto.class).block();
//       DepartmentDto departmentDto=apiClient.getDepartmentByCode(employee.getDepartmentCode());
       EmployeeDto employeeDto= EmployeeMapper.mapToEmployeeDto(employee);
       APIResponseDto apiResponseDto=new APIResponseDto();
       apiResponseDto.setEmployee(employeeDto);
       apiResponseDto.setDepartment(departmentDto);
       apiResponseDto.setOrganization(organizationDto);
       return apiResponseDto;

    }

    @Override
    public void deleteEmployeeById(Long id) {
       Employee employee=employeeRepository.findById(id).orElseThrow(()->new RuntimeException("Employee Not Found"));
       employeeRepository.delete(employee);
    }
}

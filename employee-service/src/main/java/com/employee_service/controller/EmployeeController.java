package com.employee_service.controller;

import com.employee_service.dto.APIResponseDto;
import com.employee_service.dto.EmployeeDto;
import com.employee_service.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto) {
       EmployeeDto employee= employeeService.save(employeeDto);
       return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }
    @GetMapping("/{id}")
    public ResponseEntity<APIResponseDto> getEmployeeById(@PathVariable Long id) {
        APIResponseDto employee=employeeService.getEmployeeById(id);
        return new ResponseEntity<>(employee, HttpStatus.OK);

    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployeeById(id);
        return new ResponseEntity<>("Employee Deleted", HttpStatus.OK);
    }
}

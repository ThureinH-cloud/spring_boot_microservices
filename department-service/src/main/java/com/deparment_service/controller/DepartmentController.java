package com.deparment_service.controller;

import com.deparment_service.dto.DepartmentDto;
import com.deparment_service.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;
    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
       DepartmentDto department=departmentService.saveDepartment(departmentDto);
       return new ResponseEntity<>(department, HttpStatus.CREATED);
    }
    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByCode(@PathVariable("department-code") String departmentCode) {
       DepartmentDto departmentDto=departmentService.getDepartmentByCode(departmentCode);
       return new ResponseEntity<>(departmentDto, HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteDepartment(@PathVariable("id") Long id) {
        departmentService.deleteDepartment(id);
        return new ResponseEntity<>("Department deleted", HttpStatus.OK);
    }
}

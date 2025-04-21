package com.deparment_service.service.impl;

import com.deparment_service.dto.DepartmentDto;
import com.deparment_service.entity.Department;
import com.deparment_service.mapper.DepartmentMapper;
import com.deparment_service.repository.DepartmentRepository;
import com.deparment_service.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepository departmentRepository;
    @Override
    public DepartmentDto saveDepartment(DepartmentDto departmentDto) {
        Department department= DepartmentMapper.mapToDepartment(departmentDto);
        var saveDepartment=departmentRepository.save(department);
        return DepartmentMapper.mapToDepartmentDto(saveDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByCode(String departmentCode) {
       Department department=departmentRepository.findDepartmentByDepartmentCode(departmentCode);
       return DepartmentMapper.mapToDepartmentDto(department);
    }

    @Override
    public void deleteDepartment(Long id) {
       Department department= departmentRepository.findById(id).orElseThrow(()-> new RuntimeException("Department not found"));
       departmentRepository.delete(department);
    }
}

package com.deparment_service.repository;

import com.deparment_service.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
    Department findDepartmentByDepartmentCode(String departmentCode);
}

package com.microservice.employee.restTemplateVO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "DEPARTMENT-SERVICE")
public interface FeignUtil {
    @GetMapping(path="/department/getAllDepartments")
    List<Department> getAllDepartment();

    @GetMapping(path="/department/getDepartment/{departmentId}")
    Department getDepartmentById(@PathVariable Long departmentId);

}

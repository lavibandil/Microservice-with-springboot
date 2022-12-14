package com.microservice.employee.controller;

import com.microservice.employee.entity.Employee;
import com.microservice.employee.repository.EmployeeService;
import com.microservice.employee.restTemplateVO.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping (path="/getAllEmployees")
    List<Employee> getAllEmployees(){
        System.out.println("inside get method");
        return employeeService.getAllEmployees();
    }

    @GetMapping(path="/geEmployeeById/{employeeId}")
   ResponseEntity<Object> getEmployeeById(@PathVariable Long employeeId){
        System.out.println("inside get by Id method");
        return new ResponseEntity<>(employeeService.getEmployeeById(employeeId),HttpStatus.OK);
    }

    @PostMapping(path="/addEmployee")
    ResponseEntity<String >createEmployee(@RequestBody Employee employee){
        System.out.println("inside post method");

        employeeService.createEmployee(employee);
        return new ResponseEntity<>("Employee data has been added", HttpStatus.CREATED);
    }

    @PutMapping(path="/updateEmployee")
    Employee updateEmployee(@RequestBody Employee employee) {
        System.out.println("inside put method");
        return employeeService.updateEmployee(employee);
    }

    @DeleteMapping(path="/deleteEmployee/{employeeId}")
    void deleteEmployeeById(@PathVariable Long employeeId){
        System.out.println("inside delete method");
        employeeService.deleteEmployeeById(employeeId);
    }

    @GetMapping(path="/getEmployeeWithDepartment/{employeeId}")
    RestTemplateVO getEmployeeWithDepartment(@PathVariable Long employeeId){
        System.out.println("inside employeeWithDepartment method");
        return employeeService.getEmployeeWithDepartment(employeeId);
    }

}

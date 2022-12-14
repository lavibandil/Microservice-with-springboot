package com.microservice.employee.repository;

import com.microservice.employee.entity.Employee;
import com.microservice.employee.restTemplateVO.Department;
import com.microservice.employee.restTemplateVO.FeignUtil;
import com.microservice.employee.restTemplateVO.RestTemplateVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
    FeignUtil feignUtil;

    public List<Employee> getAllEmployees(){
       return employeeRepository.findAll();
    }

    public Optional<Employee> getEmployeeById(Long employeeId){
        return employeeRepository.findById(employeeId);
    }

    public Employee createEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Employee employee){
        return employeeRepository.save(employee);
    }

    public void deleteEmployeeById(Long employeeId) {
        employeeRepository.deleteById(employeeId);
    }

   /* public RestTemplateVO getEmployeeWithDepartment(Long employeeId){
        RestTemplateVO restTemplateVO= new RestTemplateVO();
        System.out.println("Start employeeWithDepartment method");
     Optional<Employee> employee=    employeeRepository.findById(employeeId);

     Department department= restTemplate.getForObject("http://DEPARTMENT-SERVICE/department/getDepartment/"+employee.get().getEmployeeDepartmentId(), Department.class);
     restTemplateVO.setEmployee(employee.get());
     restTemplateVO.setDepartment(department);
     System.out.println("End employeeWithDepartment method");
     return restTemplateVO;
    }*/


    public RestTemplateVO getEmployeeWithDepartment(Long employeeId) {
        RestTemplateVO restTemplateVO = new RestTemplateVO();
        System.out.println("Start employeeWithDepartment method");
        Optional<Employee> employee = employeeRepository.findById(employeeId);
        Department department = feignUtil.getDepartmentById(employee.get().getEmployeeDepartmentId());
        restTemplateVO.setEmployee(employee.get());
        restTemplateVO.setDepartment(department);
        System.out.println("End employeeWithDepartment method");
        return restTemplateVO;
    }





    }

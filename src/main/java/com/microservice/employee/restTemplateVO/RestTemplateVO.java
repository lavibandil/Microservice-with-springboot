package com.microservice.employee.restTemplateVO;

import com.microservice.employee.entity.Employee;

public class RestTemplateVO {

    private Employee employee;
    private Department department;

    public RestTemplateVO() {
    }

    public RestTemplateVO(Employee employee, Department department) {
        this.employee = employee;
        this.department = department;
    }


    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "RestTemplateVO{" +
                "employee=" + employee +
                ", department=" + department +
                '}';
    }
}

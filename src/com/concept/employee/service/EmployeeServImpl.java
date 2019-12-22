package com.concept.employee.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
 
import com.concept.employee.bean.*;
import com.concept.employee.dao.*;
 
@Service
public class EmployeeServImpl {
 
    @Autowired
    EmployeeDaoImpl empdao;
 
    
    
    public static int addEmployee(Employee employee) {
        return EmployeeDaoImpl.addEmployee(employee);
    }
    
    
    public static List<Employee> getEmployees() {
        return EmployeeDaoImpl.getEmployees();
    }
    
    public static Employee getEmployee(int emplouee_id) {
        return EmployeeDaoImpl.getEmployee(emplouee_id);
    }
    
    public static int updateEmployee(Employee employee)
    {
        return EmployeeDaoImpl.updateEmployee(employee);
    }
    
    
    public static int deleteEmployee(int employee_id) {
        return EmployeeDaoImpl.deleteEmployee(employee_id);
    }
}

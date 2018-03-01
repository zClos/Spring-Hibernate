package com.pvt.service;

import com.pvt.dao.EmployeeDao;
import com.pvt.pojos.Employee;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService() {
    }

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public void saveEmployee(Employee employee) {
        employeeDao.add(employee);
    }

    public Employee getEmployee(Integer id) {
        return employeeDao.get(Employee.class, id);
    }

    public void deleteEmployee(Employee employee) {
        employeeDao.delete(employee);
    }
}

package com.pvt.service;

import com.pvt.dao.EmployeeDao;
import com.pvt.pojos.Employee;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public EmployeeService() {
    }

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void saveEmployee(Employee employee) {
        employeeDao.add(employee);
    }

    @Transactional(readOnly = true)
    public Employee getEmployee(Integer id) {
        return employeeDao.get(Employee.class, id);
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void deleteEmployee(Employee employee) {
        Assert.notNull(employee, "Employee can't be null");
        employeeDao.delete(employee);
    }
}

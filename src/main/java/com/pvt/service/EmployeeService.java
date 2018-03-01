package com.pvt.service;

import com.pvt.dao.EmployeeDao;
import com.pvt.pojos.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    public EmployeeService() {
    }

    public EmployeeService(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void saveEmployee(Employee employee) {
        employeeDao.save(employee);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public Employee getEmployee(Integer id) {
        return employeeDao.findOne(id);
    }

    @Transactional(readOnly = true, propagation = Propagation.SUPPORTS)
    public List<Employee> getEmployeeByFullName(String firstName, String lastName) {
        return employeeDao.getByFullName(firstName, lastName);
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void updateEmployee(Employee employee) {
        Integer employeeId = employee.getId();
        if (employee.getEmployeeDetail().getEmployeeId() != employeeId) {
            employee.getEmployeeDetail().setEmployeeId(employeeId);
        }
        employeeDao.save(employee);
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void deleteEmployee(Employee employee) {
        Assert.notNull(employee, "Employee can't be null");
        employeeDao.delete(employeeDao.findOne(employee.getId()));
        System.out.println("The Employee successfully deleted\n");
    }
}

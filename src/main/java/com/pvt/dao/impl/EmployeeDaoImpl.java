package com.pvt.dao.impl;

import com.pvt.dao.EmployeeDao;
import com.pvt.pojos.Employee;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao {

    @Override
    public List<Employee> getEmployeesByFirstName(String firstName) {
        TypedQuery<Employee> query = entityManager.createQuery(
                "SELECT e FROM Employee e WHERE e.firstName LIKE :firstName", Employee.class);
        query.setParameter("firstName", firstName);
        return query.getResultList();
    }

    @Override
    public List<Employee> getEmployeesByLastName(String lastName) {
        javax.persistence.Query query = entityManager.createQuery(
                "SELECT e FROM Employee e WHERE e.lastName = :lastName");
        query.setParameter("lastName", lastName);
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesByFullName(String firstName, String lastName) {
        javax.persistence.Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName");
        query.setParameter("firstName", firstName);
        query.setParameter("lastName", lastName);
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String depName) {
        javax.persistence.Query query = entityManager.createQuery("SELECT e FROM Employee e WHERE e.department = :depName");
        query.setParameter("depName", depName);
        List<Employee> employeeList = query.getResultList();
        return employeeList;
    }

}

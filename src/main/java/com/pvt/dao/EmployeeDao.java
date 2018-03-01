package com.pvt.dao;

import com.pvt.pojos.Employee;

import java.util.List;

public interface EmployeeDao extends BaseDao<Employee> {

    List<Employee> getEmployeesByFirstName(String firstName);

    List<Employee> getEmployeesByLastName(String lastName);

    List<Employee> getEmployeesByFullName(String firstName, String lastName);

    List<Employee> getEmployeesByDepartment(String depName);

    void saveEmployee(String firstName, String lastName, String depName);

}

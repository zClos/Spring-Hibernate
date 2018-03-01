package com.pvt.dao.impl;

import com.pvt.dao.EmployeeDao;
import com.pvt.pojos.Employee;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;

import java.util.List;

public class EmployeeDaoImpl extends BaseDaoImpl<Employee> implements EmployeeDao {

    @Override
    public List<Employee> getEmployeesByFirstName(String firstName) {
        Session session = getCurrentSession();
        Query query = session.createQuery("FROM Employee as e WHERE e.firstName = :firstName");
        query.setString("firstName", firstName);
        List<Employee> employeeList = query.list();
//        session.close();
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesByLastName(String lastName) {
        Session session = getCurrentSession();
        Query query = session.createQuery("FROM Employee as e WHERE e.firstName = :lastName");
        query.setString("lastName", lastName);
        List<Employee> employeeList = query.list();
//        session.close();
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesByFullName(String firstName, String lastName) {
        Session session = getCurrentSession();
        Query query = session.createQuery("FROM Employee e WHERE e.firstName = :firstName AND e.lastName = :lastName");
        query.setString("firstName", firstName);
        query.setString("lastName", lastName);
        List<Employee> employeeList = query.list();
//        session.close();
        return employeeList;
    }

    @Override
    public List<Employee> getEmployeesByDepartment(String depName) {
        Session session = getCurrentSession();
        try {
            Query query = session.createQuery("FROM Employee as e WHERE e.department = :depName");
            query.setString("depName", depName);
            List<Employee> employeeList = query.list();
            return employeeList;
        } finally {
//            session.close();
        }
    }

    @Override
    public void saveEmployee(String firstName, String lastName, String depName) {
        Session session = getCurrentSession();
        try {
            session.beginTransaction();
            Employee employee = new Employee();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            session.saveOrUpdate(employee);
//            session.getTransaction().commit();
            System.out.println("Employee " + firstName + " sucsesfully added");
        } catch (HibernateException e) {
            System.out.println("can't save " + firstName + ": " + e);
        } catch (NullPointerException e) {
            System.out.println("can't save " + firstName + ": " + depName + " doesn't exist");
        } finally {
//            session.close();
        }
    }
}

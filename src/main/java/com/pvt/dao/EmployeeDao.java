package com.pvt.dao;

import com.pvt.pojos.Employee;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    List<Employee> getByFirstName(String firstName);

    List<Employee> getByLastName(String lastName);

    @Modifying
    @Query("SELECT e FROM Employee e WHERE e.firstName = ?1 AND e.lastName = ?2")
    List<Employee> getByFullName(String firstName, String lastName);

    List<Employee> getEmployeesByDepartment(String depName);
}

package com.pvt.dao;

import com.pvt.pojos.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends CrudRepository<Department, Integer> {

    Department findByName(String name);

}

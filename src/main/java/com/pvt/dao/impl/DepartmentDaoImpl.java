package com.pvt.dao.impl;

import com.pvt.dao.DepartmentDao;
import com.pvt.pojos.Department;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;

@Repository
public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

    @Override
    public Department getDepartmentByName(String name) {
        TypedQuery<Department> query = entityManager.createQuery(
                "SELECT d FROM Department d where d.departmentName LIKE :name", Department.class);
        query.setParameter("name", name);
        return query.getSingleResult();
    }

}

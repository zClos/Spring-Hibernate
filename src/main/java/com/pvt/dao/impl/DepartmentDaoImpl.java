package com.pvt.dao.impl;

import com.pvt.dao.DepartmentDao;
import com.pvt.pojos.Department;
import org.hibernate.Query;
import org.hibernate.Session;

public class DepartmentDaoImpl extends BaseDaoImpl<Department> implements DepartmentDao {

    @Override
    public Department getDepartmentByName(String name) {
        Query query = getCurrentSession().createQuery("FROM Department where departmentName = :name");
        query.setString("name", name);
        return (Department) query.uniqueResult();
    }

    @Override
    public void saveDepartment(String name) {
        Session session = getCurrentSession();
        session.beginTransaction();
        Department department = new Department();
        department.setDepartmentName(name);
        session.saveOrUpdate(department);
        session.getTransaction().commit();
    }

}

package com.pvt.service;

import com.pvt.dao.DepartmentDao;
import com.pvt.pojos.Department;

public class DepartmentService {

    private DepartmentDao departmentDao;

    public DepartmentService() {
    }

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public void saveDepartment(Department department) {
        departmentDao.add(department);
    }

    public Department getDepartment(Integer id) {
        return departmentDao.get(Department.class, id);
    }

    public Department getDepartment(String name) {
        return departmentDao.getDepartmentByName(name);
    }

    public void deleteDepartment(Department department) {
        departmentDao.delete(department);
    }
}

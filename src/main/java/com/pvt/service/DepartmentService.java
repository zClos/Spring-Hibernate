package com.pvt.service;

import com.pvt.dao.DepartmentDao;
import com.pvt.pojos.Department;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class DepartmentService {

    private DepartmentDao departmentDao;

    public DepartmentService() {
    }

    public DepartmentService(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void saveDepartment(Department department) {
        departmentDao.add(department);
    }

    @Transactional(readOnly = true)
    public Department getDepartment(Integer id) {
        return departmentDao.get(Department.class, id);
    }

    @Transactional(readOnly = true)
    public Department getDepartment(String name) {
        return departmentDao.getDepartmentByName(name);
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void deleteDepartment(Department department) {
        departmentDao.delete(department);
    }
}

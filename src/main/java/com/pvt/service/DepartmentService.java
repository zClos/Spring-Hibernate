package com.pvt.service;

import com.pvt.dao.DepartmentDao;
import com.pvt.pojos.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentDao departmentDao;

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void saveDepartment(Department department) {
        departmentDao.save(department);
    }

    @Transactional(readOnly = true)
    public Department getDepartment(Integer id) {
        return departmentDao.findOne(id);
    }

    @Transactional(readOnly = true)
    public Department getDepartment(String name) {
        return departmentDao.findByName(name);
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void deleteDepartment(Department department) {
        departmentDao.delete(departmentDao.findOne(department.getId()));
        System.out.println("The Department successfully deleted\n");
    }
}

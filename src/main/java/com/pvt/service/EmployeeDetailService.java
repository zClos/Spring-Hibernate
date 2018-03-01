package com.pvt.service;

import com.pvt.dao.EmployeeDetailDao;
import com.pvt.pojos.EmployeeDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeDetailService {

    @Autowired
    private EmployeeDetailDao employeeDetailDao;

    public EmployeeDetailService() {
    }

    public EmployeeDetailService(EmployeeDetailDao employeeDetailDao) {
        this.employeeDetailDao = employeeDetailDao;
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void deleteEmployeeDetail(EmployeeDetail employeeDetail) {
        employeeDetailDao.delete(employeeDetailDao.findOne(employeeDetail.getEmployeeId()));
    }

}

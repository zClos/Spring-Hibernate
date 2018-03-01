package com.pvt.service;

import com.pvt.dao.impl.EmployeeDetailDaoImpl;
import com.pvt.pojos.EmployeeDetail;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

public class EmployeeDetailService {

    private EmployeeDetailDaoImpl employeeDetailDao;

    public EmployeeDetailService() {
    }

    public EmployeeDetailService(EmployeeDetailDaoImpl employeeDetailDao) {
        this.employeeDetailDao = employeeDetailDao;
    }

    @Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
    public void deleteEmployeeDetail(EmployeeDetail employeeDetail) {
        employeeDetailDao.delete(EmployeeDetail.class, employeeDetail.getEmployeeId());
    }
}

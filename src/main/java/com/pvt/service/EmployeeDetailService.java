package com.pvt.service;

import com.pvt.dao.impl.EmployeeDetailDaoImpl;
import com.pvt.pojos.EmployeeDetail;

public class EmployeeDetailService {

    private EmployeeDetailDaoImpl employeeDetailDao;

    public EmployeeDetailService() {
    }

    public EmployeeDetailService(EmployeeDetailDaoImpl employeeDetailDao) {
        this.employeeDetailDao = employeeDetailDao;
    }

    public void deleteEmployeeDetail(EmployeeDetail employeeDetail) {
        employeeDetailDao.delete(employeeDetail);
    }
}

package com.pvt.dao;

import com.pvt.pojos.Department;

public interface DepartmentDao extends BaseDao<Department> {

    Department getDepartmentByName(String name);

}

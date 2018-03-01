package com.pvt.dao;

import com.pvt.pojos.EmployeeDetail;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeDetailDao extends CrudRepository<EmployeeDetail, Integer> {
}

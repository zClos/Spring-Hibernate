package com.pvt;

import com.pvt.pojos.Department;
import com.pvt.pojos.Employee;
import com.pvt.pojos.EmployeeDetail;
import com.pvt.service.DepartmentService;
import com.pvt.service.EmployeeDetailService;
import com.pvt.service.EmployeeService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring_Hibernate.xml");
        Department department = (Department) applicationContext.getBean("department");
        DepartmentService departmentService = (DepartmentService) applicationContext.getBean("departmentService");
        departmentService.saveDepartment(department);

        EmployeeDetailService employeeDetailService = (EmployeeDetailService) applicationContext.getBean("employeeDetailService");
        EmployeeDetail employeeDetail = (EmployeeDetail) applicationContext.getBean("employeeDetail1");
        employeeDetailService.deleteEmployeeDetail(employeeDetail);

        EmployeeService employeeService = (EmployeeService) applicationContext.getBean("employeeService");
        Employee employee = (Employee) applicationContext.getBean("employee1");
        employeeService.deleteEmployee(null);

    }
}

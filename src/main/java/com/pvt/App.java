package com.pvt;

import com.pvt.pojos.Department;
import com.pvt.service.DepartmentService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring_Hibernate.xml");
        Department department = (Department) applicationContext.getBean("department");
        DepartmentService departmentService = (DepartmentService) applicationContext.getBean("departmentService");
        departmentService.saveDepartment(department);

    }
}

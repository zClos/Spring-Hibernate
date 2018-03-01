package com.pvt;

import com.pvt.pojos.Department;
import com.pvt.pojos.Employee;
import com.pvt.pojos.Meeting;
import com.pvt.service.DepartmentService;
import com.pvt.service.EmployeeService;
import com.pvt.service.MeetingService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Set;

public class App {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("Spring_Hibernate.xml");

        DepartmentService departmentService = (DepartmentService) applicationContext.getBean("departmentService");
        Department department = (Department) applicationContext.getBean("department");
        departmentService.saveDepartment(department);
        Department getDepartment = departmentService.getDepartment("someDep");
        System.out.println("\n Getting Department");
        System.out.println(getDepartment);

        EmployeeService employeeService = (EmployeeService) applicationContext.getBean("employeeService");
        Employee employee = employeeService.getEmployee(1);
        System.out.println("\n Getting Employee");
        System.out.println(employee);
        employeeService.deleteEmployee(employee);

        Set<Meeting> meetings = employee.getMeetings();
        System.out.println(meetings);

        MeetingService meetingService = (MeetingService) applicationContext.getBean("meetingService");
        meetings.forEach(meeting -> meetingService.deleteMeeting(meeting));

        departmentService.deleteDepartment(department);


    }
}

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
        DepartmentService departmentService = applicationContext.getBean(DepartmentService.class);
        Department department = (Department) applicationContext.getBean("department");
        departmentService.saveDepartment(department);
        Department getDepartment = departmentService.getDepartment("someDep");
        System.out.println("Getting Department");
        System.out.println(getDepartment + "\n");

        EmployeeService employeeService = applicationContext.getBean(EmployeeService.class);
        Employee employee = employeeService.getEmployeeByFullName("Vasia", "Pupkin").get(0);
        System.out.println("Getting Employee");
        System.out.println(employee + "\n");
        employeeService.deleteEmployee(employee);

        Set<Meeting> meetings = employee.getMeetings();
        System.out.println(meetings + "\n");

        MeetingService meetingService = applicationContext.getBean(MeetingService.class);
        meetings.forEach(meeting -> meetingService.deleteMeeting(meeting));

        departmentService.deleteDepartment(department);
    }
}

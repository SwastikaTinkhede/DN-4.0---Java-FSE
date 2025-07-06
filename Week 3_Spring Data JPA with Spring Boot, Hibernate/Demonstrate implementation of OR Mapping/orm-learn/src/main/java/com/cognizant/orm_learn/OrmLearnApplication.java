package com.cognizant.orm_learn;

import com.cognizant.orm_learn.model.Department;
import com.cognizant.orm_learn.model.Employee;
import com.cognizant.orm_learn.model.Skill;
import com.cognizant.orm_learn.service.DepartmentService;
import com.cognizant.orm_learn.service.EmployeeService;
import com.cognizant.orm_learn.service.SkillService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.sql.Date;
import java.util.List;

@SpringBootApplication
public class OrmLearnApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

    private static EmployeeService employeeService;
    private static DepartmentService departmentService;
    private static SkillService skillService;

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);
        departmentService = context.getBean(DepartmentService.class);
        skillService = context.getBean(SkillService.class);

        // Choose the test method to run
        testAssignSkillToEmployee();
    }

    private static void testAddEmployee() {
        LOGGER.info("Start");

        Employee employee = new Employee();
        employee.setName("Ravi");
        employee.setSalary(35000);
        employee.setPermanent(true);
        employee.setDateOfBirth(Date.valueOf("1995-04-10"));

        Department dept = departmentService.get(1);
        employee.setDepartment(dept);

        employeeService.save(employee);

        LOGGER.debug("Saved Employee: {}", employee);
        LOGGER.info("End");
    }

    private static void testGetEmployee() {
        LOGGER.info("Start");

        Employee employee = employeeService.get(1);
        LOGGER.debug("Employee: {}", employee);
        LOGGER.debug("Department: {}", employee.getDepartment());

        LOGGER.info("End");
    }

    private static void testUpdateEmployee() {
        LOGGER.info("Start");

        Employee employee = employeeService.get(1);
        Department newDept = departmentService.get(2);

        employee.setDepartment(newDept);
        employeeService.save(employee);

        LOGGER.debug("Updated Employee: {}", employee);
        LOGGER.info("End");
    }

    private static void testAssignSkillToEmployee() {
        LOGGER.info("Start");

        Employee employee = employeeService.get(1);
        Skill skill1 = skillService.get(1);
        Skill skill2 = skillService.get(2);

        employee.setSkillList(List.of(skill1, skill2));

        employeeService.save(employee);

        LOGGER.debug("Employee with Skills: {}", employee);
        LOGGER.info("End");
    }
}

package com.cognizant.learn;

import com.cognizant.learn.manual.EmployeeHibernateDAO;
import com.cognizant.learn.model.Employee;
import com.cognizant.learn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class LearnApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(LearnApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Spring Data JPA
        employeeService.addEmployee(new Employee("Preeti", "IT", 60000));

        // Hibernate (Manual)
        EmployeeHibernateDAO hibernateDAO = new EmployeeHibernateDAO();
        hibernateDAO.addEmployee(new Employee("Amit", "HR", 55000));
    }
}

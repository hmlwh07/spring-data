package com.example.democallbacktemplate;

import com.example.democallbacktemplate.ds.Employee;
import com.example.democallbacktemplate.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;

@SpringBootApplication
public class DemoCallbackTemplateApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(DemoCallbackTemplateApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        employeeService.listAllEmployee()
                .forEach(System.out::println);
        System.out.println("Average salary::$"+
                employeeService.avgResultSetExtractor());
        System.out.println("FindByEmail::"+
                employeeService.findEmployeeByEmail("richard@gmail.com"));

        System.out.println();
        employeeService.createEmployee(new Employee(
                7,"John","Smith","smith@gmail.com",3000.0
                ));
        employeeService.listAllEmployee()
                .forEach(System.out::println);

        System.out.println("AvgNative::"+
                employeeService.avgNativeWay());

        System.out.println("ModernWay::"+
                employeeService.avgModernWay());

    }
}

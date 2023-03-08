package com.example.democonnection.dao;

import com.example.democonnection.ds.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

@Repository
public class EmployeeDao {

    private JdbcTemplate jdbcTemplate;

    public EmployeeDao(DataSource dataSource) {
        jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource);
    }

    public void createEmployee(Employee employee) {

        if(employee.getId() < 0){
            throw new RuntimeException("id cannot be negative!");

        }

        jdbcTemplate.update("""
                        insert into employee(id,first_name,last_name,email,salary)
                        values (?,?,?,?,?)
                        """,
                employee.getId(),
                employee.getFirstName(),
                employee.getLastName(),
                employee.getEmail(),
                employee.getSalary()
        );
    }
}

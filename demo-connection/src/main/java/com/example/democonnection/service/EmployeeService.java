package com.example.democonnection.service;

import com.example.democonnection.dao.EmployeeDao;
import com.example.democonnection.ds.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;


    //@Transactional
    public void createEmployeeWithTransaction(){
        employeeDao.createEmployee(new Employee(12,"Honey","Kira",
                "kira@gmail.com",2000));
        employeeDao.createEmployee(new Employee(13,"John","Lin",
                "lin@gmail.com",4000));
        employeeDao.createEmployee(new Employee(14,"Joy","Won",
                "won@gmail.com",5000));
        employeeDao.createEmployee(new Employee(15,"Jorden","Smith",
                "smith@gmail.com",6000));

    }
}

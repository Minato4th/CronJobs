package com.endava.util;

import com.endava.entities.Employee;

import java.time.LocalDateTime;


public class EmployeesGenerator {
    private  Employee employee;
    private  int num;
    private  String firstName;
    private  String lastName;
    private  LocalDateTime date;

    public  Employee getCurrentEmployee(){
        this.num++;
        this.firstName = "F" + num;
        this.lastName = "L" + num;
        this.date = LocalDateTime.now();

        return this.employee = new Employee(this.firstName, this.lastName, this.date);
    }

}

package com.endava.cron;

import com.endava.entities.Employee;
import com.endava.util.EmployeesGenerator;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.ArrayList;
import java.util.List;

public class EmployeeCronJob implements Job{

    private static EmployeesGenerator init;
    private static List<Employee> employees;

    static {
        employees = new ArrayList<>();
        init = new EmployeesGenerator();
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        this.employees.add(this.init.getCurrentEmployee());

        System.out.println("----Current List of Employees---");
        this.employees.forEach(System.out::println);
        System.out.println("--------------------------------");
    }
}

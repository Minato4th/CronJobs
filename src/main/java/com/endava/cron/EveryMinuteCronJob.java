package com.endava.cron;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;


public class EveryMinuteCronJob implements Job {

    private static LocalDateTime localDateTime;

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        this.localDateTime  = LocalDateTime.now();
        System.out.println("Current time " + this.localDateTime);
    }
}

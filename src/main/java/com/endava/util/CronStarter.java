package com.endava.util;

import com.endava.cron.EmployeeCronJob;
import com.endava.cron.EveryMinuteCronJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.io.IOException;


public class CronStarter {

    private JobDetail job1;
    private JobDetail job2;

    private Trigger trigger1;
    private Trigger trigger2;

    private Scheduler scheduler1;
    private Scheduler scheduler2;


    public void startCrons() throws SchedulerException, IOException {

        initJob1();
        initJob2();

        System.in.read();

        this.scheduler1.shutdown();
        this.scheduler2.shutdown();
    }

    private void initJob1() throws SchedulerException, IOException {
        this.job1 = JobBuilder.newJob(EveryMinuteCronJob.class)
                .withIdentity("job1", "group1").build();

        this.trigger1 = TriggerBuilder.newTrigger()
                .withIdentity("FactoryTrigger1", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/60 * * * * ?"))
                .build();

        this.scheduler1 = new StdSchedulerFactory().getScheduler();

        this.scheduler1.start();
        this.scheduler1.scheduleJob(this.job1, this.trigger1);

    }

    private void initJob2() throws SchedulerException, IOException {
        this.job2 = JobBuilder.newJob(EmployeeCronJob.class)
                .withIdentity("job2", "group2").build();

        this.trigger2 = TriggerBuilder.newTrigger()
                .withIdentity("FactoryTrigger2", "group2")
                .withSchedule(CronScheduleBuilder.cronSchedule("0/30 * * * * ?"))
                .build();

        this.scheduler2 = new StdSchedulerFactory().getScheduler();

        this.scheduler2.start();
        this.scheduler2.scheduleJob(this.job2, this.trigger2);

    }

}

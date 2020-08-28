package com.quartz;

import com.quartz.src.org.quartz.examples.example2.SimpleJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.impl.StdSchedulerFactory;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.JobKey.jobKey;

/**
 * @author ymj
 * @Date： 2020/8/7 10:09
 * @description:
 */
public class quartz2 {
    public static void main(String[] args) throws SchedulerException {
        // 1、创建调度器Scheduler（工厂模式）
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();

        // 直接触发 job
        JobDetail job = newJob(PrintWordsJob.class).withIdentity("job8", "group1").storeDurably().build();
        scheduler.addJob(job, true);
        scheduler.triggerJob(jobKey("job8", "group1"));
        scheduler.start();

    }
}

package com.quartz;

import com.quartz.src.org.quartz.examples.example8.SimpleJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.quartz.impl.calendar.AnnualCalendar;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.concurrent.TimeUnit;

import static org.quartz.CronScheduleBuilder.cronSchedule;
import static org.quartz.DateBuilder.dateOf;
import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;


/**
 * . 简单触发
 * . cron 表达式触发
 * . job 设置参数
 * . 异常处理
 * . 暂停触发
 * . 假期功能 calendar
 * . jobListener， 一个job 触发另一个 job
 *
 * @author ymj
 * @Date： 2020/7/31 17:24
 * @description:
 */
public class quartz {

    /**
     *  SchedulerFactory
     *      Scheduler
     *  JobDetail
     *      JobBuilder（implements Job）
     *  Trigger
     *      1. Trigger
     *      2. SimpleTrigger 简单触发器
     *      3. CronTrigger cron表达式
     *  scheduler(执行)
     */
    public static void main(String[] args) throws SchedulerException, InterruptedException {
        // 1、创建调度器Scheduler（工厂模式）
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        //  JobDataMap
        JobDataMap jobDataMap = new JobDataMap(); // JobData
        jobDataMap.put("k1", "JobDetail:job1"); // JobData
        // 2、创建JobDetail实例，并与PrintWordsJob类绑定(Job执行内容)
        JobDetail jobDetail = JobBuilder
                .newJob(PrintWordsJob.class)
                .withIdentity("job1", "group1") // 任务名， 组名称
                .setJobData(jobDataMap)                    // 替换JobData
                .usingJobData(jobDataMap)                  // 增加 JobData 内容
                .usingJobData("k2","JobDetail:job2")  // JobData
                .build();
        // 3、构建Trigger实例,每隔1s执行一次(job执行方式)
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1", "triggerGroup1") // 触发器， 组名称
                .usingJobData("k2","Trigger:job2")  // JobData
                .withSchedule( SimpleScheduleBuilder
                        .simpleSchedule()
                        .withIntervalInSeconds(1) // 间隔1
                        .withRepeatCount(5) // 执行6次
                        //.repeatForever() //一直执行
                )
                // .withSchedule(CronScheduleBuilder.cronSchedule("0 0/1 * * * ?"))
                .build();
//                .startNow();//立即生效


        /**
         * 4、执行 (执行内容 + 执行方式 放入调度器中)
         *  1个 scheduler 可以放 很多对 job-trigger
         */
        scheduler.scheduleJob(jobDetail, trigger);
        scheduler.start();
        // 计算机下一个周期时间 (minute 整点)
        Date runTime = DateBuilder.evenMinuteDate(new Date());
        System.out.println("--------scheduler start ! -----"+ new Date().toString() +"-------" + runTime.toString());
        // 睡眠
        TimeUnit.SECONDS.sleep(10);
        //5、结束执行
        scheduler.shutdown();
        System.out.println("--------scheduler shutdown ! ------------");
        // scheduler 信息
        SchedulerMetaData metaData = scheduler.getMetaData();
        System.out.println("Executed " + metaData.getNumberOfJobsExecuted() + " jobs.");
    }

    public static void cronTrigger(){
        CronTrigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .withSchedule(cronSchedule("0/20 * * * * ?"))
                .build();

        System.out.println(trigger.getCronExpression());
    }

    public static void Trigger(){
        JobDetail jobDetail = JobBuilder
                .newJob(PrintWordsJob.class)
                .withIdentity("job1", "group1") // 任务名， 组名称
                .usingJobData("k2","JobDetail:job2")  // JobData
                .build();
        Trigger trigger = TriggerBuilder
                .newTrigger()
                .withIdentity("trigger1", "triggerGroup1") // 触发器， 组名称
                .usingJobData("k2","Trigger:job2")  // JobData
                .withSchedule(
                        SimpleScheduleBuilder
                                .simpleSchedule()
                                .withIntervalInSeconds(1) // 间隔1
                                .withRepeatCount(5) // 执行6次
                                .withMisfireHandlingInstructionNowWithExistingCount() // set misfire instruction
                                //.repeatForever() //一直执行
                )
                .withPriority(1)
                .startNow()
                .withDescription("这是一个触发器")
                .forJob(jobDetail)
                .build();

        System.out.println(trigger.getMisfireInstruction());
    }

    /**
     * This example will demonstrate how calendars can be used to exclude periods of time when scheduling should not take
     * place.
     * @throws SchedulerException
     */
    public static void Calendar() throws SchedulerException {

        SchedulerFactory sf = new StdSchedulerFactory();
        Scheduler scheduler = sf.getScheduler();

        // Add the holiday calendar to the schedule
        AnnualCalendar holidays = new AnnualCalendar();
        // fourth of July (July 4)
        Calendar fourthOfJuly = new GregorianCalendar(2005, 6, 4);
        holidays.setDayExcluded(fourthOfJuly, true);

        // tell the schedule about our holiday calendar
        scheduler.addCalendar("holidays", holidays, false, false);

        // schedule a job to run hourly, starting on halloween
        // at 10 am
        Date runDate = dateOf(0, 0, 10, 31, 10);

        JobDetail job = newJob(SimpleJob.class).withIdentity("job1", "group1").build();

        SimpleTrigger trigger = newTrigger()
                .withIdentity("trigger1", "group1")
                .startAt(runDate)
                .withSchedule(
                        simpleSchedule()
                        .withIntervalInHours(1)
                        .repeatForever()
                )
                .modifiedByCalendar("holidays")
                .build();

        // schedule the job and print the first run date
        Date firstRunTime = scheduler.scheduleJob(job, trigger);

        scheduler.start();
        scheduler.shutdown(true);

    }

}

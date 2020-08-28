package com.quartz;

import lombok.extern.slf4j.Slf4j;
import org.quartz.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

/**
 * @author ymj
 * @Date： 2020/7/31 17:24
 * @description:
 */
@Slf4j
public class PrintWordsJob implements Job {

    @Override
    public void execute(JobExecutionContext context) {
        // 组名称.job任务名
        JobKey jobKey = context.getJobDetail().getKey();
        /** JobDataMap */
        JobDataMap dataMap = context.getJobDetail().getJobDataMap();
        JobDataMap dataMap2 = context.getTrigger().getJobDataMap();
        JobDataMap dataMap3 = context.getMergedJobDataMap();


        System.out.println(jobKey);
        System.out.println(dataMap.get("k2"));
        System.out.println(dataMap2.get("k2"));
        System.out.println(dataMap3.get("k1") + "---" + dataMap3.get("k2"));
        String printTime = new SimpleDateFormat("yy-MM-dd HH-mm-ss").format(new Date());
        System.out.println("PrintWordsJob start at:" + printTime + ", prints: Hello Job-" + new Random().nextInt(100));
    }
}

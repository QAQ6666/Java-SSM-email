package cn.beida.ssm.util;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class Crontrigg {

    public static void main(String[] args) throws Exception {
        // 创建工作对象
        JobDetail job = JobBuilder.newJob(email.class).withIdentity("dummyJobName", "group1").build();
        // 为了立即测试，可以使用下面的代码，每隔5秒钟执行一次
         int secDelta = 10;
         Trigger trigger = TriggerBuilder
         .newTrigger()
         .withIdentity("dummyTriggerName", "group1")
         .withSchedule(
         CronScheduleBuilder.cronSchedule("0/" + secDelta + " * * * * ?"))
         .build();
//        // 在每天早上的9点多（不超过3分钟）执行
//        Random rand = new Random(System.currentTimeMillis());
//        int secDelta = rand.nextInt(60 * 3);
//        // 创建触发器对象
//        Trigger trigger = TriggerBuilder.newTrigger().withIdentity("dummyTriggerName", "group1")
//                .withSchedule(CronScheduleBuilder.cronSchedule(secDelta + " 0 9 ? * SUN-SAT")).build();

        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        // 将触发器与工作关联起来
        scheduler.scheduleJob(job, trigger);
    }
}

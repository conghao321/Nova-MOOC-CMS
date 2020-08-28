package com.nova.order.mq;

import com.nova.order.config.RabbitMQConfig;
import com.nova.order.service.TaskService;
import com.nova.framework.domain.task.NvTask;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

/**
 * @author haocong
 * @date Aug2020
 * @version 1.0
 **/
@Component
public class ChooseCourseTask {
    private static final Logger LOGGER = LoggerFactory.getLogger(ChooseCourseTask.class);

    @Autowired
    TaskService taskService;

    @RabbitListener(queues = RabbitMQConfig.NV_LEARNING_FINISHADDCHOOSECOURSE)
    public void receiveFinishChoosecourseTask(NvTask NvTask){
        if(NvTask!=null && StringUtils.isNotEmpty(NvTask.getId())){
            taskService.finishTask(NvTask.getId());
        }
    }

    @Scheduled(cron="0/3 * * * * *")
    //定时发送加选课任务
    public void sendChoosecourseTask(){
        //得到1分钟之前的时间
        Calendar calendar = new GregorianCalendar();
        calendar.setTime(new Date());
        calendar.set(GregorianCalendar.MINUTE,-1);
        Date time = calendar.getTime();
        List<NvTask> novaTaskList = taskService.findNovaTaskList(time, 100);
        System.out.println(novaTaskList);
        //调用service发布消息，将添加选课的任务发送给mq
        for(NvTask nvTask:novaTaskList){
            //取任务
            if(taskService.getTask(nvTask.getId(),nvTask.getVersion())>0){
                String ex = nvTask.getMqExchange();//要发送的交换机
                String routingKey = nvTask.getMqRoutingkey();//发送消息要带routingKey
                taskService.publish(nvTask,ex,routingKey);
            }

        }
    }

    //定义任务调试策略
//    @Scheduled(cron="0/3 * * * * *")//每隔3秒去执行
//       @Scheduled(fixedRate = 3000) //在任务开始后3秒执行下一次调度
//       @Scheduled(fixedDelay = 3000) //在任务结束后3秒后才开始执行
        public void task1(){
        LOGGER.info("===============测试定时任务1开始===============");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("===============测试定时任务1结束===============");

    }

    //定义任务调试策略
//    @Scheduled(cron="0/3 * * * * *")//每隔3秒去执行
//    @Scheduled(fixedRate = 3000) //在任务开始后3秒执行下一次调度
//       @Scheduled(fixedDelay = 3000) //在任务结束后3秒后才开始执行
    public void task2(){
        LOGGER.info("===============测试定时任务2开始===============");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LOGGER.info("===============测试定时任务2结束===============");

    }
}

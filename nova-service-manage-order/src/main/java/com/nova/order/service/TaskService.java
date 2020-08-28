package com.nova.order.service;

import com.nova.framework.domain.task.NvTask;
import com.nova.framework.domain.task.NvTaskHis;
import com.nova.order.dao.NovaTaskHisRepository;
import com.nova.order.dao.NovaTaskRepository;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author haocong
 * @date Aug2020
 * @version 1.0
 **/
@Service
public class TaskService {

    @Autowired
    NovaTaskRepository novaTaskRepository;

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Autowired
    NovaTaskHisRepository novaTaskHisRepository;

    //查询前n条任务
    public List<NvTask> findNovaTaskList(Date updateTime, int size){
        //设置分页参数
        Pageable pageable = new PageRequest(0,size);
        //查询前n条任务
        Page<NvTask> all = novaTaskRepository.findByUpdateTimeBefore(pageable, updateTime);
        List<NvTask> list = all.getContent();
        return list;
    }

    //发布消息
    public void publish(NvTask NovaTask,String ex,String routingKey){
        Optional<NvTask> optional = novaTaskRepository.findById(NovaTask.getId());
        if(optional.isPresent()){
            rabbitTemplate.convertAndSend(ex,routingKey,NovaTask);
            //更新任务时间
            NvTask one = optional.get();
            one.setUpdateTime(new Date());
            novaTaskRepository.save(one);
        }



    }

    //获取任务
    @Transactional
    public int getTask(String id,int version){
        //通过乐观锁的方式来更新数据表，如果结果大于0说明取到任务
        int count = novaTaskRepository.updateTaskVersion(id, version);
        return count;
    }

    //完成任务
    @Transactional
    public void finishTask(String taskId){
        Optional<NvTask> optionalNovaTask = novaTaskRepository.findById(taskId);
        if(optionalNovaTask.isPresent()){
            //当前任务
            NvTask NovaTask = optionalNovaTask.get();
            //历史任务
            NvTaskHis NovaTaskHis = new NvTaskHis();
            BeanUtils.copyProperties(NovaTask,NovaTaskHis);
            novaTaskHisRepository.save(NovaTaskHis);
            novaTaskRepository.delete(NovaTask);
        }
    }
}

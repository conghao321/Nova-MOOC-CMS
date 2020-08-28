package com.nova.order.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 *
 * @author haocong
 * @date Aug2020
 * @version 1.0
 */

@Configuration
public class RabbitMQConfig {
    //添加选课任务交换机
    public static final String EX_LEARNING_ADDCHOOSECOURSE = "ex_learning_addchoosecourse";

    //完成添加选课消息队列
    public static final String NV_LEARNING_FINISHADDCHOOSECOURSE = "nova_learning_finishaddchoosecourse";

    //添加选课消息队列
    public static final String NV_LEARNING_ADDCHOOSECOURSE = "nova_learning_addchoosecourse";

    //添加选课路由key
    public static final String NV_LEARNING_ADDCHOOSECOURSE_KEY = "addchoosecourse";
    //完成添加选课路由key
    public static final String NV_LEARNING_FINISHADDCHOOSECOURSE_KEY = "finishaddchoosecourse";

    /**
     * 交换机配置
     * @return the exchange
     */
    @Bean(EX_LEARNING_ADDCHOOSECOURSE)
    public Exchange EX_DECLARE() {
        return ExchangeBuilder.directExchange(EX_LEARNING_ADDCHOOSECOURSE).durable(true).build();
    }
    //声明队列完成添加选课队列
    @Bean(NV_LEARNING_FINISHADDCHOOSECOURSE)
    public Queue QUEUE_DECLARE() {
        Queue queue = new Queue(NV_LEARNING_FINISHADDCHOOSECOURSE,true,false,true);
        return queue;
    }

    //声明队列 添加选课队列
    @Bean(NV_LEARNING_ADDCHOOSECOURSE)
    public Queue QUEUE_DECLARE_2() {
        Queue queue = new Queue(NV_LEARNING_ADDCHOOSECOURSE,true,false,true);
        return queue;
    }
    /**
     * 绑定完成添加选课队列到交换机 .
     * @param queue    the queue
     * @param exchange the exchange
     * @return the binding
     */
    @Bean
    public Binding binding_finishaddchoose_processtask(@Qualifier("nova_learning_finishaddchoosecourse") Queue queue, @Qualifier(EX_LEARNING_ADDCHOOSECOURSE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(NV_LEARNING_FINISHADDCHOOSECOURSE_KEY).noargs();
    }
    /**
     * 绑定添加选课队列到交换机 .
     * @param queue    the queue
     * @param exchange the exchange
     * @return the binding
     */
    @Bean
    public Binding binding_addchoose_processtask(@Qualifier("nova_learning_addchoosecourse") Queue queue, @Qualifier(EX_LEARNING_ADDCHOOSECOURSE) Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(NV_LEARNING_ADDCHOOSECOURSE_KEY).noargs();
    }

}

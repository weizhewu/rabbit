package com.example.rabbit.config;

import com.example.rabbit.constant.RabbitMqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 广播队列配置
 * @createDate: 2023/5/6 11:23
 **/
@Configuration
public class FanoutQueueConfig {

    /**
     * 声明广播队列1
     * @return 广播队列1
     */
    @Bean
    public Queue fanoutQueue1(){
        return new Queue(RabbitMqConstant.Queue.FANOUT_QUEUE1);
    }

    /**
     * 声明广播队列2
     * @return 广播队列2
     */
    @Bean
    public Queue fanoutQueue2(){
        return new Queue(RabbitMqConstant.Queue.FANOUT_QUEUE2);
    }

    /**
     * 声明广播交换机
     * @return 广播交换机
     */
    @Bean
    public FanoutExchange fanoutExchange(){
        /*
         * 名字
         * 持久化
         * 不自动删除
         */
        return new FanoutExchange(RabbitMqConstant.Exchange.FANOUT_EXCHANGE,
                true,
                false);
    }

    /**
     * 将广播队列1绑定到广播交换机
     * @param fanoutQueue1 广播队列1
     * @param fanoutExchange 广播交换机
     * @return Binding
     */
    @Bean
    public Binding fanoutQueue1BindingFanoutExchange(Queue fanoutQueue1,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue1)
                .to(fanoutExchange);
    }

    /**
     * 将广播队列2绑定到广播交换机
     * @param fanoutQueue2 广播队列2
     * @param fanoutExchange 广播交换机
     * @return Binding
     */
    @Bean
    public Binding fanoutQueue2BindingFanoutExchange(Queue fanoutQueue2,FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue2)
                .to(fanoutExchange);
    }
}

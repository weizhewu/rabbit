package com.example.rabbit.config;

import com.example.rabbit.constant.RabbitMqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.CustomExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 延迟队列配置
 * @createDate: 2023/5/5 15:17
 **/
@Configuration
public class DelayedQueueConfig {

    /**
     * 声明延迟队列
     * @return 延迟队列
     */
    @Bean
    public Queue delayedQueue(){
        return new Queue(RabbitMqConstant.Queue.DELAYED_QUEUE);
    }

    /**
     * 声明延迟交换机
     * @return 延迟交换机
     */
    @Bean
    public CustomExchange delayedExchange(){
        HashMap<String,Object> arguments = new HashMap<>(1);
        // 声明延迟交换机的类型：路由直连
        arguments.put(RabbitMqConstant.X_DELAYED_TYPE,RabbitMqConstant.DIRECT);
        /*
         * 名字
         * 交换机类型
         * 持久化
         * 不自动删除
         * 交换机类型
         */
        return new CustomExchange(RabbitMqConstant.Exchange.DELAYED_EXCHANGE,
                RabbitMqConstant.ExchangeType.X_DELAYED_MESSAGE,
                true,
                false,
                arguments
        );
    }

    /**
     * 将延迟队列通过routingKey绑定到延迟交换机
     * @param delayedQueue 延迟队列
     * @param delayedExchange 延迟交换机
     * @return Binding
     */
    @Bean
    public Binding delayedQueueBindingDelayedExchange(Queue delayedQueue,CustomExchange delayedExchange){
        return BindingBuilder.bind(delayedQueue)
                .to(delayedExchange)
                .with(RabbitMqConstant.Key.DELAYED_ROUTING_KEY)
                .noargs();
    }
}

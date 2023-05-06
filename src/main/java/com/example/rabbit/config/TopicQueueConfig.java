package com.example.rabbit.config;

import com.example.rabbit.constant.RabbitMqConstant;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 主题队列配置
 * @createDate: 2023/5/6 9:55
 **/
@Configuration
public class TopicQueueConfig {

    /**
     * 声明主题队列1
     * @return 主题队列
     */
    @Bean
    public Queue message1Queue(){
        return new Queue(RabbitMqConstant.Queue.TOPIC_QUEUE1);
    }

    /**
     * 声明主题队列2
     * @return 主题队列
     */
    @Bean
    public Queue message2Queue(){
        return new Queue(RabbitMqConstant.Queue.TOPIC_QUEUE2);
    }

    /**
     * 声明主题交换机
     * @return 主题交换机
     */
    @Bean
    public TopicExchange topicExchange(){
        /*
         * 名字
         * 持久化
         * 不自动删除
         */
        return new TopicExchange(RabbitMqConstant.Exchange.TOPIC_EXCHANGE,
                true,
                false);
    }

    /**
     * 将主题队列1通过routingKey绑定到主题交换机
     * @param message1Queue 主题队列
     * @param topicExchange 主题交换机
     * @return Binding
     */
    @Bean
    public Binding topicQueue1BindingTopicExchange(Queue message1Queue,TopicExchange topicExchange){
        return BindingBuilder.bind(message1Queue)
                .to(topicExchange)
                .with(RabbitMqConstant.Key.TOPIC_ROUTING_KEY_MESSAGE1_KEY);
    }

    /**
     * 将主题队列2通过routingKey绑定到主题交换机
     * @param message2Queue 主题队列
     * @param topicExchange 主题交换机
     * @return Binding
     */
    @Bean
    public Binding topicQueue2BindingTopicExchange(Queue message2Queue,TopicExchange topicExchange){
        return BindingBuilder.bind(message2Queue)
                .to(topicExchange)
                .with(RabbitMqConstant.Key.TOPIC_ROUTING_KEY_ALL);
    }
}

package com.example.rabbit.customer;

import com.rabbitmq.client.Channel;
import org.springframework.messaging.Message;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 主题队列消费者
 * @createDate: 2023/5/6 10:29
 **/
public interface TopicConsumer {
    /**
     * 接收主题队列消息
     * @param message 消息
     * @param channel 信道
     */
    void receiveMessage1(Message<Object> message, Channel channel);

    /**
     * 接收主题队列消息
     * @param message 消息
     * @param channel 信道
     */
    void receiveMessage2(Message<Object> message, Channel channel);
}

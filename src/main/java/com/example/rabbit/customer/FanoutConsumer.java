package com.example.rabbit.customer;

import com.rabbitmq.client.Channel;
import org.springframework.messaging.Message;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 广播队列消费者
 * @createDate: 2023/5/6 11:34
 **/
public interface FanoutConsumer {
    /**
     * 接收广播队列消息
     * @param message 消息
     * @param channel 信道
     */
    void receiveMessage1(Message<Object> message, Channel channel);

    /**
     * 接收广播队列消息
     * @param message 消息
     * @param channel 信道
     */
    void receiveMessage2(Message<Object> message, Channel channel);
}

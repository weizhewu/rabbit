package com.example.rabbit.customer;

import com.rabbitmq.client.Channel;
import org.springframework.messaging.Message;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 延迟消息消费者
 * @createDate: 2023/5/5 15:51
 **/
public interface DelayedConsumer {
    /**
     * 接收延迟消息
     * @param message 消息
     * @param channel 信道
     */
    void receiveMessage(Message<Object> message, Channel channel);
}

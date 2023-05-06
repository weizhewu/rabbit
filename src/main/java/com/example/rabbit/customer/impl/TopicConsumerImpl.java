package com.example.rabbit.customer.impl;

import com.alibaba.fastjson.JSON;
import com.example.rabbit.constant.RabbitMqConstant;
import com.example.rabbit.customer.TopicConsumer;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 主题队列消费者实现
 * @createDate: 2023/5/6 10:29
 **/
@Service
@Slf4j
public class TopicConsumerImpl implements TopicConsumer {
    @Override
    @RabbitListener(queues = RabbitMqConstant.Queue.TOPIC_QUEUE1)
    public void receiveMessage1(Message<Object> message, Channel channel) {
        log.info("当前时间：{}，主题队列消费者message1收到主题队列消息：{}",new Date(), JSON.toJSONString(message.getPayload()));
    }

    @Override
    @RabbitListener(queues = RabbitMqConstant.Queue.TOPIC_QUEUE2)
    public void receiveMessage2(Message<Object> message, Channel channel) {
        log.info("当前时间：{}，主题队列消费者message2收到主题队列消息：{}",new Date(), JSON.toJSONString(message.getPayload()));

    }
}

package com.example.rabbit.customer.impl;

import com.alibaba.fastjson.JSON;
import com.example.rabbit.constant.RabbitMqConstant;
import com.example.rabbit.customer.FanoutConsumer;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 广播队列消费者实现
 * @createDate: 2023/5/6 11:39
 **/
@Service
@Slf4j
public class FanoutConsumerImpl implements FanoutConsumer {

    @Override
    @RabbitListener(queues = RabbitMqConstant.Queue.FANOUT_QUEUE1)
    public void receiveMessage1(Message<Object> message, Channel channel) {
        log.info("当前时间：{}，广播队列消费者message1收到广播队列消息：{}",new Date(), JSON.toJSONString(message.getPayload()));
    }

    @Override
    @RabbitListener(queues = RabbitMqConstant.Queue.FANOUT_QUEUE2)
    public void receiveMessage2(Message<Object> message, Channel channel) {
        log.info("当前时间：{}，广播队列消费者message2收到广播队列消息：{}",new Date(), JSON.toJSONString(message.getPayload()));
    }
}

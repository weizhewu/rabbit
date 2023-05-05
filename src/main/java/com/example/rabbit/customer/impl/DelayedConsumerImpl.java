package com.example.rabbit.customer.impl;

import com.alibaba.fastjson.JSON;
import com.example.rabbit.constant.RabbitMqConstant;
import com.example.rabbit.customer.DelayedConsumer;
import com.rabbitmq.client.Channel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 延迟消息消费者实现类
 * @createDate: 2023/5/5 15:55
 **/
@Service
@Slf4j
public class DelayedConsumerImpl implements DelayedConsumer {
    @Override
    @RabbitListener(queues = RabbitMqConstant.Queue.DELAYED_QUEUE)
    public void receiveMessage(Message<Object> message, Channel channel) {
        log.info("当前时间：{}，收到延迟队列的消息：{}",new Date(), JSON.toJSONString(message.getPayload()));
    }
}

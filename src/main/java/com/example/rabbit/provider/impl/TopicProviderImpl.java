package com.example.rabbit.provider.impl;

import com.example.rabbit.constant.RabbitMqConstant;
import com.example.rabbit.provider.TopicProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 主题队列生产者实现
 * @createDate: 2023/5/6 10:17
 **/
@Service
@Slf4j
public class TopicProviderImpl implements TopicProvider {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendTopicMessage(String message) {
        log.info("当前时间：{} 发送一条消息：{} 给topic交换机",new Date(),message);
        rabbitTemplate.convertAndSend(RabbitMqConstant.Exchange.TOPIC_EXCHANGE,
                RabbitMqConstant.Key.TOPIC_ROUTING_KEY_MESSAGE1_KEY,
                message);
    }
}

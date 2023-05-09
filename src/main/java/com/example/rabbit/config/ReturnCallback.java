package com.example.rabbit.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.ReturnedMessage;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 回调函数: return返回
 * @createDate: 2023/5/9 14:53
 **/
@Slf4j
public class ReturnCallback implements RabbitTemplate.ReturnsCallback {
    @Override
    public void returnedMessage(ReturnedMessage returnedMessage) {
        log.info("return exchange: {}, routingKey: {}, replyCode: {}, replyText: {}",
                returnedMessage.getExchange(),
                returnedMessage.getRoutingKey(),
                returnedMessage.getReplyCode(),
                returnedMessage.getReplyText());
    }
}

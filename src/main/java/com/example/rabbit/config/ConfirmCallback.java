package com.example.rabbit.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 回调函数：confirm确认
 * @createDate: 2023/5/9 14:54
 **/
@Slf4j
public class ConfirmCallback implements RabbitTemplate.ConfirmCallback {
    @Override
    public void confirm(CorrelationData correlationData, boolean b, String s) {
        log.debug("相关数据: " + correlationData);
        log.debug("确认情况: " + b);
        log.debug("原因: " + s);
    }
}

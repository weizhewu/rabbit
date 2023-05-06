package com.example.rabbit.provider.impl;

import com.example.rabbit.constant.RabbitMqConstant;
import com.example.rabbit.provider.DelayedProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 延迟消息生产者实现
 * @createDate: 2023/5/5 15:45
 **/
@Service
@Slf4j
public class DelayedProviderImpl implements DelayedProvider {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendDelayedTimeMessage(String message, Integer delayedTime) {
        log.info("当前时间：{} 发送一条信息：{} 给delayed交换机，delayedTime：{}", new Date(),message,delayedTime);
        rabbitTemplate.convertAndSend(RabbitMqConstant.Exchange.DELAYED_EXCHANGE, RabbitMqConstant.Key.DELAYED_ROUTING_KEY, message, (msg -> {
                // 发送消息 并 设置delayedTime
                msg.getMessageProperties().setDelay(delayedTime);
                return msg;
            })
        );
    }
}

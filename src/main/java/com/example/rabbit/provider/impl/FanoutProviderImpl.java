package com.example.rabbit.provider.impl;

import com.example.rabbit.constant.RabbitMqConstant;
import com.example.rabbit.provider.FanoutProvider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 广播队列生产者实现
 * @createDate: 2023/5/6 11:35
 **/
@Service
@Slf4j
public class FanoutProviderImpl implements FanoutProvider {
    @Resource
    private RabbitTemplate rabbitTemplate;

    @Override
    public void sendFanoutMessage(String message) {
        log.info("当前时间：{} 广播队列发送一条消息：{} 给fanout交换机",new Date(),message);
        rabbitTemplate.convertAndSend(RabbitMqConstant.Exchange.FANOUT_EXCHANGE,"",message);
    }
}

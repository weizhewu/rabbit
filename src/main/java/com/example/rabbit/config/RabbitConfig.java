package com.example.rabbit.config;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Configuration;


/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: rabbit消息回调处理
 * @createDate: 2023/5/9 14:27
 **/
@Slf4j
@Configuration
@AllArgsConstructor
public class RabbitConfig implements InitializingBean {
    private RabbitTemplate rabbitTemplate;

    /**
     * 完善rabbit配置
     */
    @Override
    public void afterPropertiesSet() {
        //设置开启Mandatory，才能触发回调函数，无论消息推送结果怎么样都会强制调用回调函数
        rabbitTemplate.setMandatory(true);
        rabbitTemplate.setConfirmCallback(new ConfirmCallback());
        rabbitTemplate.setReturnsCallback(new ReturnCallback());
    }
}

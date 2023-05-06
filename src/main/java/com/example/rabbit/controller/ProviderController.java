package com.example.rabbit.controller;

import com.example.rabbit.provider.DelayedProvider;
import com.example.rabbit.provider.TopicProvider;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 生产者
 * @createDate: 2023/5/5 16:13
 **/
@RestController
@RequestMapping(value = "/provider/")
public class ProviderController {
    @Resource
    private DelayedProvider delayedProvider;
    @Resource
    private TopicProvider topicProvider;

    /**
     * 发送延迟消息
     * @param message 消息
     * @param delayedTime 延时 单位是毫秒
     */
    @PostMapping(value = "sendDelayedTimeMessage")
    public void sendDelayedTimeMessage(@RequestParam String message,@RequestParam Integer delayedTime){
        delayedProvider.sendDelayedTimeMessage(message, delayedTime);
    }

    /**
     * 发送主题队列消息
     * @param message 消息
     */
    @PostMapping(value = "sendTopicMessage")
    public void sendTopicMessage(@RequestParam String message){
        topicProvider.sendTopicMessage(message);
    }
}

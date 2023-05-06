package com.example.rabbit.provider;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 主题队列生产者
 * @createDate: 2023/5/6 10:13
 **/
public interface TopicProvider {

    /**
     * 主题队列发送消息
     * @param message 消息
     */
    void sendTopicMessage(String message);
}

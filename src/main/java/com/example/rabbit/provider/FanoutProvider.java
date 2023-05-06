package com.example.rabbit.provider;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 广播队列生产者
 * @createDate: 2023/5/6 11:34
 **/
public interface FanoutProvider {

    /**
     * 广播队列发送消息
     * @param message 消息
     */
    void sendFanoutMessage(String message);
}

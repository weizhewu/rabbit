package com.example.rabbit.provider;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: 延迟消息生产者
 * @createDate: 2023/5/5 15:42
 **/
public interface DelayedProvider {
    /**
     * 发送延迟消息
     * @param message 消息
     * @param delayedTime 延时 单位是毫秒
     */
    void sendDelayedTimeMessage(String message,Integer delayedTime);
}

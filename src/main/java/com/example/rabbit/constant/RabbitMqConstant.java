package com.example.rabbit.constant;

/**
 * @version 1.0.0
 * @author: wei-zhe-wu
 * @description: rabbitmq常量类
 * @createDate: 2023/5/5 15:02
 **/
public interface RabbitMqConstant {
    public static final String X_DELAYED_TYPE = "x-delayed-type";
    public static final String DIRECT = "direct";
    /**
     * 队列
     */
    interface Queue{
        // 延迟队列
        public static final String DELAYED_QUEUE = "delayed_queue";
    }

    /**
     * 交换机
     */
    interface Exchange{
        // 延迟交换机
        public static final String DELAYED_EXCHANGE = "delayed_exchange";

    }

    /**
     * 交换机类型
     */
    interface ExchangeType{
        // 延迟消息
        public static final String X_DELAYED_MESSAGE = "x-delayed-message";
    }

    /**
     * routeingKey
     */
    interface Key{
        // 延迟队列routeingKey
        public static final String DELAYED_ROUTING_KEY ="delayed_routing_key";
    }
}

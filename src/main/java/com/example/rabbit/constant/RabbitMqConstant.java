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

        // 主题队列
        public static final String TOPIC_QUEUE1 = "topic_queue1";
        public static final String TOPIC_QUEUE2 = "topic_queue2";
    }

    /**
     * 交换机
     */
    interface Exchange{
        // 延迟交换机
        public static final String DELAYED_EXCHANGE = "delayed_exchange";

        // 主题交换机
        public static final String TOPIC_EXCHANGE = "topic_exchange";

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

        // 主题队列routeingKey
        public static final String TOPIC_ROUTING_KEY ="topic_routing_key";
        public static final String TOPIC_ROUTING_KEY_ALL = TOPIC_ROUTING_KEY + ".#";
        public static final String TOPIC_ROUTING_KEY_ONE = TOPIC_ROUTING_KEY + ".*";

        public static final String TOPIC_ROUTING_KEY_MESSAGE1_KEY = TOPIC_ROUTING_KEY+ ".message1";
        public static final String TOPIC_ROUTING_KEY_MESSAGE2_KEY = TOPIC_ROUTING_KEY+ ".message2";
    }
}

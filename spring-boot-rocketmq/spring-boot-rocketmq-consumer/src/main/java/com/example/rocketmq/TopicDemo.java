package com.example.rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;

/**
 * 创建topic
 */
public class TopicDemo {
    public static void main(String[] args) throws MQClientException {
        DefaultMQProducer producer = new DefaultMQProducer("HAOKE_IM");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        /**
         * key:broker名称
         * newTopic:topic名称
         * queueNum:队列数(分区)
         */
        producer.createTopic("broker_haoke_im", "haoke_im_topic", 8);
        System.out.println("创建topic成功");
        producer.shutdown();
    }
}
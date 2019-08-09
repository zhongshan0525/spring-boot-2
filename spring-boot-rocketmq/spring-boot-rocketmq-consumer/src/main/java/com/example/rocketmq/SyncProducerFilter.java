package com.example.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * Description:消息过滤器
 * RocketMQ支持根据用户自定义属性进行过滤，过滤表达式类似于SQL的where，如：a> 5 AND b ='abc'
 * Author: yanlongzhang
 * Date: 2019-08-05
 */
public class SyncProducerFilter {
    public static void main(String[] args) throws Exception {
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        producer.setNamesrvAddr("127.0.0.1:9876");
        producer.start();
        String msgStr = "美女001";
        Message msg = new Message("TopicTest","SEND_MSG",
                msgStr.getBytes(RemotingHelper.DEFAULT_CHARSET));
        msg.putUserProperty("age", "22");
        msg.putUserProperty("sex", "女");
        // 发送消息
        SendResult sendResult = producer.send(msg,100000);
        System.out.println("消息状态：" + sendResult.getSendStatus());
        System.out.println("消息id：" + sendResult.getMsgId());
        System.out.println("消息queue：" + sendResult.getMessageQueue());
        System.out.println("消息offset：" + sendResult.getQueueOffset());
        System.out.println(sendResult);
        producer.shutdown();
    }
}

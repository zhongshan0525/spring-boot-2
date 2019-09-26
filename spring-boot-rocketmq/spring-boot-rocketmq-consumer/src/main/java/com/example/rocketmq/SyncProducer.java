package com.example.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 发送消息同步
 * 可靠的同步传输用于大量场景,如重要通知消息、短信通知、短信营销系统等
 * @author zyl
 */
public class SyncProducer {
    public static void main(String[] args) throws Exception {
        //使用生产者组名称进行实例化.
        DefaultMQProducer producer = new
                DefaultMQProducer("please_rename_unique_group_name");
        // 指定名称服务器地址.
        producer.setNamesrvAddr("localhost:9876");
        //启动实例.
        producer.start();
        for (int i = 0; i < 10; i++) {
            //创建消息实例，指定主题，标记和消息正文.
            Message msg = new Message("TopicTest", "TagA",
                    ("Hello RocketMQ " + i).getBytes(RemotingHelper.DEFAULT_CHARSET)
            );
            //Call send message to deliver message to one of brokers.
            SendResult sendResult = producer.send(msg,100000);
            System.out.printf("%s%n", sendResult);
        }
        //生产者实例不再使用后关闭.
        producer.shutdown();
    }
}
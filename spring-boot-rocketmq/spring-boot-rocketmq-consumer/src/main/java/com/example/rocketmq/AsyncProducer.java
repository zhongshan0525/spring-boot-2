package com.example.rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.remoting.common.RemotingHelper;

/**
 * 异步发送消息
 * 异步传输通常用于响应时间敏感的业务方案
 */
public class AsyncProducer {
    public static void main(String[] args) throws Exception {
        //使用生产者组名称进行实例化.
        DefaultMQProducer producer = new DefaultMQProducer("please_rename_unique_group_name");
        //指定名称服务器地址.
        producer.setNamesrvAddr("localhost:9876");
        //启动实例.
        producer.start();
        // 发送失败的重试次数
        producer.setRetryTimesWhenSendAsyncFailed(0);
        for (int i = 0; i < 100; i++) {
                final int index = i;
                //Create a message instance, specifying topic, tag and message body.
                Message msg = new Message("TopicTest",
                    "TagA",
                    "OrderID188",
                    "Hello world".getBytes(RemotingHelper.DEFAULT_CHARSET));
                producer.send(msg, new SendCallback() {
                            @Override
                            public void onSuccess(SendResult sendResult) {
                                System.out.printf("%-10d OK %s %n", index,
                                        sendResult.getMsgId());
                            }
                            @Override
                            public void onException(Throwable e) {
                                System.out.printf("%-10d Exception %s %n", index, e);
                                e.printStackTrace();
                            }
                },100000);
        }

        //producer.shutdown()要注释掉，否则发送失败。原因是，异步发送，还未来得及发送就被关闭了
        System.out.println("发送成功");
    }
}
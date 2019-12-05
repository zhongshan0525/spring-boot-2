package com.example;

import com.github.kevinsawicki.http.HttpRequest;

import java.nio.charset.Charset;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * 并发工具CountDownLatch用法
 * @author zhangYanLong
 * @date 2019/11/28
 */
public class DemoCountDownLatch {
    //模拟并发
    public static void main(String[] args) throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(3);

        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,10,1000, TimeUnit.MILLISECONDS,new LinkedBlockingDeque<Runnable>());
        // 依次创建并启动处于等待状态的5个MyRunnable线程
        for (int i = 0; i < 3; ++i) {
            executor.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        latch.await();
                        Thread.sleep(1000L);
                        HttpRequest request = new HttpRequest("http://promotion-web-test.hotcake.longhu.net/api/promotion/channel/verification", HttpRequest.METHOD_POST);
                        request.contentType(HttpRequest.CONTENT_TYPE_FORM, HttpRequest.CHARSET_UTF8);
                        request.form("body", "{\"type\":\"1\",\"userId\":\"1000888\",\"id\":\"18889002\",\"code\":\"13667662624\"}", Charset.defaultCharset().name());

                        System.out.println(request.body());
                        System.out.println("hhhhhhhhhh");
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            latch.countDown();
        }

        System.out.println("用于触发处于等待状态的线程开始工作......");

        Thread.sleep(10000);
        System.out.println("用于触发处于等待状态的线程工作完成，等待状态线程开始工作......");
        System.out.println("Bingo!");
    }

}

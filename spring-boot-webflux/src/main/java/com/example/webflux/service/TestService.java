package com.example.webflux.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangYanLong
 * @date 2019/11/6
 */
@Service
public class TestService {

    public String execute() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }

}

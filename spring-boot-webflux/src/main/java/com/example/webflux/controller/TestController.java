package com.example.webflux.controller;

import com.example.webflux.service.TestService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.util.concurrent.TimeUnit;

/**
 * @author zhangYanLong
 * @date 2019/11/6
 */
@Slf4j
@RestController
public class TestController {

    @Autowired
    private TestService testService;

    @GetMapping("sync")
    public String sync() {
        log.info("sync method start");
        String result = this.execute();
        log.info("sync method end");
        return result;
    }

    @GetMapping("async/mono")
    public Mono<String> asyncMono() {
        log.info("async method start");
        Mono<String> result = Mono.fromSupplier(this::execute);
        log.info("async method end");
        return result;
    }

    public String execute() {
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "hello";
    }
}

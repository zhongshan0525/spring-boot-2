package com.example.aop.controller;

import com.example.aop.annotation.Log;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author zhangYanLong
 * @date 2019/11/5
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @Log("执行方法一")
    @GetMapping("/v1/{name}")
    public String get(@PathVariable("name")String name){
        return name;
    }
}

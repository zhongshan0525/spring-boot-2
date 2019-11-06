package com.example.aop.config;

import com.example.aop.model.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * @author zhangYanLong
 * @date 2019/11/6
 */
@Configuration
@ComponentScan(value = "com.example.aop.model",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE,classes = User.class)
})
public class WebConfig {

//    @Bean
//    public User user(){
//        return new User("张三","123456");
//    }
}

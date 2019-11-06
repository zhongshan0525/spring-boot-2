package com.example.aop;

import com.example.aop.config.WebConfig;
import com.example.aop.model.SysLog;
import com.example.aop.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.util.Arrays;

@SpringBootApplication
@EnableAspectJAutoProxy
public class SpringBootAopApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootAopApplication.class, args);

        ApplicationContext context = new AnnotationConfigApplicationContext(WebConfig.class);
        User bean = (User) context.getBean("user");
//        String[] beanNamesForType = context.getBeanNamesForType(User.class);
//        String[] beanDefinitionNames = context.getBeanDefinitionNames();
//        Arrays.stream(beanDefinitionNames).forEach(System.out::println);
        System.out.println(bean);
    }

}

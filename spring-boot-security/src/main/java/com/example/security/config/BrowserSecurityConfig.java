package com.example.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)  //开启授权注解
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin() // 表单方式
                .loginPage("/static/login.html")   //指定跳转到登录页面的请求URL
                .loginProcessingUrl("/login")   //对应登录页面form表单的action="/login"
                .and()
                .authorizeRequests() // 授权配置
//                .antMatchers("/static/login.html").permitAll()     //跳转到登录页面的请求不被拦截
                .antMatchers("/static/login.html", "/static/css/**").permitAll()
                .anyRequest()  // 所有请求
                .authenticated() // 都需要认
                .and().csrf().disable();
        http.exceptionHandling()
                .accessDeniedPage("/static/error.html");    //权限不足跳转页面

    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
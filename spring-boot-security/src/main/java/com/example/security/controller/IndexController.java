package com.example.security.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Auther: zyl
 * @Date: 2019\7\2 0002 17:43
 * @Description:
 */
@RestController
@RequestMapping("/index")
public class IndexController {

    @GetMapping("/hello")
    public String hello(){
        return "hello security";
    }

    @GetMapping("/admin")
    @PreAuthorize("hasAuthority('admin')")
    public String admin(){
        return "你拥有访问admin的权限";
    }
}

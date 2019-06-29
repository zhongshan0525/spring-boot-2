package com.example.thymeleaf.controller;

import com.example.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: zyl
 * @Date: 2019\6\29 0029 15:43
 * @Description:
 */
@Controller
public class UserController {

    @RequestMapping("index")
    public String index(ModelMap modelMap){
        User user = new User();
        user.setUsername("张三");
        modelMap.addAttribute(user);
        return "index";
    }
}

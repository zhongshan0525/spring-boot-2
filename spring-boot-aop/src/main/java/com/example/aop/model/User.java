package com.example.aop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

/**
 * @author zhangYanLong
 * @date 2019/11/6
 */
@Component
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private String username;
    private String password;
}

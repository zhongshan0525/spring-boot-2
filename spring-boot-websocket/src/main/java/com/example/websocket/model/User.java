package com.example.websocket.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @Author: zhangyanlong
 * @Date: 2019/7/1 21:23
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "user")
@ApiModel("用户模型")
public class User {
    @ApiModelProperty("用户id")
    @Id
    @GeneratedValue
    private int id;

    @ApiModelProperty("用户姓名")
    private String name;
}

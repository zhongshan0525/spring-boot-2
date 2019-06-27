package com.example.swagger.model;

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
 * @Date: 2019/5/18 23:51
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "servant")
@ApiModel("英灵模型")
public class Servant {

    @ApiModelProperty("英灵id")
    @Id
    @GeneratedValue
    private int id;

    @ApiModelProperty("英灵姓名")
    private String name;

    @ApiModelProperty("英灵性别")
    private String sex;

    @ApiModelProperty("英灵1技能")
    private String skill1;

    @ApiModelProperty("英灵2技能")
    private String skill2;

    @ApiModelProperty("英灵3技能")
    private String skill3;

    @ApiModelProperty("英灵宝具")
    private String noblePhantasm;

}

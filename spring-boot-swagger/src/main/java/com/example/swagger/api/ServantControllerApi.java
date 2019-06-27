package com.example.swagger.api;

import com.example.swagger.model.Servant;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;

import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: zhangyanlong
 * @Date: 2019/5/19 8:45
 */
@Api(value = "用户接口",description = "用户接口,提供用户的增删改查")
public interface ServantControllerApi {

    @ApiOperation("查询所有用户")
    List<Servant> findAll();

    /**
     * map类型无法查看model,只能声明返回的模型
     * @return
     */
    @ApiOperation(value = "查询用户,返回map",response = Servant.class)
    Map<String,Object> findMap();

    @ApiOperation("通过id查询")
    @ApiImplicitParam(name = "id", value = "用户ID", required = true, dataType = "Long", paramType = "path")
    Optional<Servant> findById(int id);

    @ApiOperation("添加英灵")
    void add(Servant servant);
}

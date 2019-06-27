package com.example.swagger.controller;

import com.example.swagger.api.ServantControllerApi;
import com.example.swagger.model.Servant;
import com.example.swagger.service.ServantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

/**
 * @Author: zhangyanlong
 * @Date: 2019/5/19 9:09
 */
@RestController
@RequestMapping("/servant")
public class ServantController implements ServantControllerApi {
    @Autowired
    private ServantService servantService;
    /**
     * 查询所有用户
     * @return 用户集合
     */
    @Override
    @GetMapping("/findAll")
    public List<Servant> findAll() {
        return servantService.findAll();
    }

    /**
     * 查询所有用户
     * @return 用户集合
     */
    @Override
    @GetMapping("/findMap")
    public Map<String, Object> findMap() {
        Map map = new HashMap();
        List<Servant> userList = servantService.findAll();
        map.put("data",userList);
        return map;
    }

    /**
     * 通过id查询英灵
     * @param id 英灵id
     * @return 英灵实体
     */
    @Override
    @GetMapping("/findById/{id}")
    public Optional<Servant> findById(@PathVariable("id") int id) {
        return servantService.findById(id);
    }

    /**
     * 添加英灵
     * @param servant 英灵
     */
    @Override
    @PostMapping("/add")
    public void add(Servant servant) {
        servantService.add(servant);
    }


}

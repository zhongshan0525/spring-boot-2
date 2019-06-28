package com.example.swagger.service;

import com.example.swagger.dao.ServantRepository;
import com.example.swagger.model.Servant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * @Author: zhangyanlong
 * @Date: 2019/5/19 9:07
 */
@Service
public class ServantService {
    @Autowired
    private ServantRepository servantRepository;

    /**
     * 查询所有用户
     *
     * @return 用户集合
     */
    public List<Servant> findAll() {
        return servantRepository.findAll();
    }

    /**
     * 通过id查询英灵
     *
     * @param id 英灵id
     * @return 英灵
     */
//    public Optional<Servant> findById(int id) {
//        return servantRepository.(id);
//    }

    /**
     * 添加英灵
     *
     * @param servant 英灵
     */
    public void add(Servant servant) {
        servantRepository.save(servant);
    }
}

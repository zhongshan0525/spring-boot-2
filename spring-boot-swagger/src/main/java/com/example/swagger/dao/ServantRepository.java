package com.example.swagger.dao;

import com.example.swagger.model.Servant;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * @Author: zhangyanlong
 * @Date: 2019/5/19 12:35
 */
public interface ServantRepository extends JpaRepository<Servant,Integer> {

}

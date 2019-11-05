package com.example.aop.repository;

import com.example.aop.model.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author zhangYanLong
 * @date 2019/11/5
 */
@Repository
public interface SysLogRepository extends JpaRepository<SysLog,Integer> {
}

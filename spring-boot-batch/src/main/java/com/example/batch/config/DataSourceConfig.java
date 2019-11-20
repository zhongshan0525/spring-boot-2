package com.example.batch.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @author zhangYanLong
 * @date 2019-11-12
 */
@Configuration
public class DataSourceConfig {
    @Bean("datasource")
    @ConfigurationProperties(prefix="spring.datasource")
    @Primary
    public DataSource batchDatasource() {
        return DataSourceBuilder.create().build();
    }

    @Bean("targetDatasource")
    @ConfigurationProperties(prefix="spring.target-datasource")
    public DataSource targetDatasource() {
        return DataSourceBuilder.create().build();
    }
}

package com.felix.rice.api.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;

import com.alibaba.druid.pool.DruidDataSource;

/**
 * 传统的注入方式，编写druid数据源的配置类，当不使用该方法时，将@Configuration注释掉即可
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-30
 */
@Deprecated
// @Configuration
public class RiceDataSourceConfig {
    /**
     * 从配置文件中读取数据源配置
     * @return druid数据源
     */
    @Bean
    @ConfigurationProperties("spring.datasource")
    public DataSource dataSource() {
        return new DruidDataSource();
    }
}

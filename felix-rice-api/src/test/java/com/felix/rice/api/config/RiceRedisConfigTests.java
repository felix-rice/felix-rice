package com.felix.rice.api.config;

import java.io.Serializable;

import javax.annotation.Resource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-09-04
 */
@Slf4j
@SpringBootTest
public class RiceRedisConfigTests {
    @Resource
    private RiceRedisConfig riceRedisConfig;
    @Resource
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    public void testLettuceConnectionFactory() {
        RedisConnectionFactory lettuceConnectionFactory = riceRedisConfig.redisConnectionFactory();
        log.info("lettuceConnectionFactory is: {}", lettuceConnectionFactory);
    }

    @Test
    public void testRedisTemplate() {
        RedisTemplate<String, Serializable> redisTemplate = riceRedisConfig
                .redisTemplate(riceRedisConfig.redisConnectionFactory());
        log.info("RedisTemplate is: {}", redisTemplate);
    }

    @Test
    public void testAutowiredRedisTemplate() {
        log.info("RedisTemplate is: {}", redisTemplate);
    }
}

package com.felix.rice.api;

import java.io.Serializable;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import com.felix.rice.component.entity.User;
import com.felix.rice.component.service.UserService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootTest
class FelixRiceApiApplicationTests {
    @Resource
    private DataSource dataSource;
    @Resource
    private UserService userService;

    @Resource
    private RedisTemplate<String, Serializable> redisTemplate;

    @Test
    void contextLoads() {
        User user = userService.getUser(1L);
        ValueOperations<String, Serializable> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(user.getId().toString(), user.toString());
        log.info("user is: {}", user);
        log.info("cur datasource is: {}", dataSource.getClass().getSimpleName());
    }

}

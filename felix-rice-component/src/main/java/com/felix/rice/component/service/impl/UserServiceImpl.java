package com.felix.rice.component.service.impl;

import org.springframework.stereotype.Service;

import com.felix.rice.component.entity.User;
import com.felix.rice.component.mapper.UserMapper;
import com.felix.rice.component.service.UserService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-30
 */
@Slf4j
@Service
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }
    @Override
    public User getUser(Long id) {
        log.info("id is: {}", id);
        User user = userMapper.getUser(id);
        log.info("user is: {}", user.toString());
        return user;
    }

    @Override
    public void cacheUser(User user) {

    }
}

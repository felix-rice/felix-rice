package com.felix.rice.component.service;

import com.felix.rice.component.entity.User;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-30
 */
public interface UserService {
    User getUser(Long id);
}

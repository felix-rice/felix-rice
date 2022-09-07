package com.felix.rice.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.felix.rice.component.entity.User;
import com.felix.rice.component.result.WebResponse;
import com.felix.rice.component.service.UserService;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-09-04
 */
@RestController
@RequestMapping("rice/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public WebResponse<User> getUser(@PathVariable(name = "id") Long id) {
        return WebResponse.success(userService.getUser(id));
    }
}

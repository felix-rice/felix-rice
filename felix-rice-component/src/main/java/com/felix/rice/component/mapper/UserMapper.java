package com.felix.rice.component.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.felix.rice.component.entity.User;

/**
 * @author lixin40 <lixin40@kuaishou.com>
 * Created on 2022-08-30
 */
@Mapper
public interface UserMapper {
    User getUser(@Param("id") Long id);
}
